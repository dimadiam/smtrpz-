//'main' method must be in a class 'Rextester'.
//openjdk version '11.0.5' 

import java.util.*;
import java.lang.*;

class Lab3 {
    public static void main(String[] args) {
        CardRegister cr = new CardRegister(10, 15);
        cr.getCard(0, 0, new Date(10, 05, 2020));
        Card c = cr.getCard(0, 1, new Date(2, 05, 2020));
    //  cr.cardBlock(2);
        System.out.println(Stile.enter(c, cr));
        c = cr.getDataCard(2);
        System.out.println(c.n);
    }
}
class Date {
    int day;
    int mounth;
    int year;
    public Date (int day, int mounth, int year) {
        this.day = day;
        this.mounth = mounth;
        this.year = year;
    }
    public static boolean eq(Date d1, Date d2) {
        if (d1.year > d2.year) return true;
        if (d1.year < d2.year) return false;
        if (d1.mounth > d2.mounth) return true;
        if (d1.mounth < d2.mounth) return false;
        if (d1.day > d2.day) return true;
        return false;
    }
}
class DataRegistrCard {
    int id;
    int qtyN;
    int qtyRefuse;
    public DataRegistrCard (int id, int qtyN, int qtyRefuse) {
        this.id = id;
        this.qtyN = qtyN;
        this.qtyRefuse = qtyRefuse;
    }
}
class Card {
    boolean enable;
    boolean overdue;
    int n;
    int id;
    String type1;
    String type2;
    Date term;
    public Card (int id, String type, String type2, Date term) {
        this.id = id;
        this.type1 = type;
        this.type2 = type2;
        this.n = 0;
        this.enable = true;
        this.overdue = false;
        this.term = term;
    }
} 
class CardRegister {
    private int cardUniqId;    
    private int days;
    private int n;

    private Card[] cards;
    private DataRegistrCard[] dataCards;

    public CardRegister (int days, int n) {
        this.cardUniqId = 1;
        this.days = days;
        this.n = n;
        this.cards = new Card[1];
        this.dataCards = new DataRegistrCard[1];
    }
    
    private Card push(Card c) {
        int l = this.cards.length;
        if (l == 1) this.cards[0] = c;
        else {
            Card[] arr = new Card[l + 1];
            for(int i = 0; i < l; i++) arr[i] = this.cards[i];
            arr[l] = c;
            this.cards = arr;
        }
        return c;
    }
    private DataRegistrCard pushDataCard(DataRegistrCard c) {
        int l = this.dataCards.length;
        if (l == 1) this.dataCards[0] = c;
        else {
            DataRegistrCard[] arr = new DataRegistrCard[l + 1];
            for(int i = 0; i < l; i++) arr[i] = this.dataCards[i];
            arr[l] = c;
            this.dataCards = arr;
        }
        return c;
    }
    private String nameOfType(int nType, int nSubType) {
        String type = "";
        if (nType == 0) {
            if (nSubType == 0) type = "n";
            else if (nSubType == 1) type = "morning";
            else if (nSubType == 2) type = "evening";        
            else if (nSubType == 3) type = "night";
            else if (nSubType == 4) type = "nDays";
            else type = "season";
        } else {
            if (nSubType == 1) type = "special";
            else if (nSubType == 2) type = "vip";
            else type = "base";
        }
        return type;
    }
    
    public Card getCard(int nType, int otherType, Date term) {
        String type1 = this.nameOfType(0, nType), 
               type2 = this.nameOfType(1, otherType); 
       
        Card c1 = new Card(this.cardUniqId++, type1, type2, term);
        if (type1 == "nDays") c1.n = this.days;
        else if (type1 == "n") c1.n = this.n;
        this.pushDataCard(new DataRegistrCard(c1.id, 0, 0));
        return this.push(c1);
    } 
    public Card getDataCard(int id) {
        for(int i = 0; i < this.cards.length; i++) {
            if (this.cards[i].id == id) return this.cards[i];
        }
        return new Card (-1, "", "", new Date(0, 0, 0));
    }
    public DataRegistrCard[] getDataCards(int nType, int otherType) {
        if (nType == -1 && otherType == -1) {
            return this.dataCards;   
        } 
        String type1 = this.nameOfType(0, nType), 
                type2 = this.nameOfType(1, otherType); 
        int j = 0;
        Card[] result = new Card[this.cards.length];
        if (nType != -1 && otherType == -1) {
            for(int i = 0; i < this.cards.length; i++) {
                if (this.cards[i].type1 == type1) {
                    result[j++] = this.cards[i];
                }
            }
        } else if (nType == -1 && otherType != -1) {
            for(int i = 0; i < this.cards.length; i++) {
                if (this.cards[i].type2 == type2) {
                    result[j++] = this.cards[i];
                }
            }
        } else {
            for(int i = 0; i < this.cards.length; i++) {
                if (this.cards[i].type1 == type1 && this.cards[i].type2 == type2) {
                    result[j++] = this.cards[i];
                }
            }
        }
        DataRegistrCard[] dc = new DataRegistrCard[j];
        for(int i = 0; i < j; i++) {
            for(int k = 0; k < this.dataCards.length; k++) {
                if (result[i].id == this.dataCards[k].id) {
                    dc[i] = this.dataCards[k];
                    break;
                }
            }
        }
        return dc;    
    }
    public boolean setDataCard(int id, String action) {
        if (action == "enter") {
            for(int k = 0; k < this.dataCards.length; k++) {
                if (id == this.dataCards[k].id) {
                    this.dataCards[k].qtyN++;
                    Card cur = this.getDataCard(id);
                    if (cur.type1 == "n") {
                        cur.n--;
                        if (cur.n < 1) return this.cardBlock(id);
                    }
                    return true;
                }
            }
        } else if (action == "no enter") {
            for(int k = 0; k < this.dataCards.length; k++) {
                if (id == this.dataCards[k].id) {
                    this.dataCards[k].qtyRefuse++;
                    return false;
                }
            }
        }
        return false;
    }
    public boolean cardBlock(int id) {
        Card card = this.getDataCard(id);
        if (card.id == -1 || !card.enable) return false;
        card.enable = false;
        return true;
    }
}
class Stile {
    
    public static boolean enter(Card c, CardRegister cr) {
        if (cr.getDataCard(c.id) != c) return false;
        if (c.enable && !c.overdue) {
            if (c.type2 == "special") Stile.warn();
            return cr.setDataCard(c.id, "enter");
        } 
        return cr.setDataCard(c.id, "no enter");
    } 
    public static void warn() {
        System.out.println("warn");
    } 
}