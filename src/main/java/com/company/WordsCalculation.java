package com.company;

import java.util.Arrays;

public class WordsCalculation {

    public static String [] wordsWithDiffChars(String line){
        String [] array = line.split(" ");
        boolean notSimilar=false;
        String finalLine="";
        for (int i = 0; i < array.length; i++) {
            String word = array[i];
            char[] arrayOfWordLetters = word.toCharArray();
            for (int itter = 0; itter < word.length(); itter++) {
               if(isHasSimilarCharInArray(arrayOfWordLetters, arrayOfWordLetters[itter])){
                   notSimilar=true;
               }
            }
            if(!notSimilar){
                finalLine+=word+" ";
            }
            notSimilar=false;
        }
        return finalLine.split(" ");
    }
    public static boolean isHasSimilarCharInArray(char [] arrayOfChars , char letter){
        int counter = 0 ;
        for (int itter = 0; itter < arrayOfChars.length; itter++) {
            if(arrayOfChars[itter]==letter){
                ++counter;
            }
            if(counter==2){
                return true;
            }
        }
        return false;
    }
}

