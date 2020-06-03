import com.company.animals.Eagle;
import com.company.animals.Lion;
import com.company.animals.Zebra;
import com.company.cages.BirdAviary;
import com.company.cages.LionAviary;
import com.company.cages.UngulatesAviary;
import com.company.exceptions.NoFreePlaceException;
import com.company.exceptions.RemovingAnimalNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AviaryTest {

    
    @Test
        public void fillUngulatesCageByZebras_returns_cage_with_zebras() throws NoFreePlaceException {
            int expected = 3;
            UngulatesAviary<Zebra> ungulatesAviary = new UngulatesAviary<>(3);
            Zebra zebra = new Zebra("Amanda",12,4,1.9,120);
            Zebra zebra1 = new Zebra("Lolek",16,4,2,140);
            Zebra zebra2 = new Zebra("Zeus",5,4,1.2,40);
            ungulatesAviary.addAnimal(zebra);
            ungulatesAviary.addAnimal(zebra1);
            ungulatesAviary.addAnimal(zebra2);
            int actual = ungulatesAviary.getSize();
            Assertions.assertEquals(expected,actual);
    }

    @Test
    public void fillEaglesCageAndRemoveNotFoundEagle_throws_RemovingAnimalNotFoundException() throws  NoFreePlaceException {
        Eagle eagle = new Eagle("Ben", 15, 4, 1.2, 10,"2");
        Eagle eagle1 = new Eagle("Tom", 23, 4, 1.5, 11,"2");
        BirdAviary<Eagle> eagleBirdAviary = new BirdAviary<>(2);
        eagleBirdAviary.addAnimal(eagle);
        eagleBirdAviary.addAnimal(eagle1);
        Eagle notExistedEagle = new Eagle("Bengamin", 1, 1, 1, 1,"1");
        String expected = notExistedEagle.getName() + " not found in the cage ";
        Exception exception = Assertions.assertThrows(RemovingAnimalNotFoundException.class, () -> {
            eagleBirdAviary.removeAnimal(notExistedEagle);
        });
        String actual = exception.getMessage();
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void overfillLionsCage_throws_NoFreePlaceException() throws NoFreePlaceException {
        Lion lion = new Lion("Tyler", 15, 4, 1.2, 98);
        Lion lion1 = new Lion("Tom", 23, 4, 1.5, 115);
        Lion lion2 = new Lion("Ben", 8, 4, 1, 87);
        String expected = "No free places for the  : "+lion2.getName();
        LionAviary<Lion> lionAviary = new LionAviary<>(2);
        lionAviary.addAnimal(lion);
        lionAviary.addAnimal(lion1);
        Exception exception = Assertions.assertThrows(NoFreePlaceException.class, () -> {
            lionAviary.addAnimal(lion2);
        });
        String actual = exception.getMessage();
        Assertions.assertEquals(expected,actual);
    }
}
