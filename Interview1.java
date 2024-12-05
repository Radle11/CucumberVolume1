package jPractice;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Interview1 {
    public static void main(String[] args) {
        List<List<Integer>> inputList = new ArrayList<>();
        /*
        1 2 1 1 1
        3 3 3 1 1
        4 2 3 2 1
        4 3 3 4 2
        4 4 4 4 2
         */
        inputList.add(Arrays.asList(1,2,1,1,1));
        inputList.add(Arrays.asList(3,3,3,1,1));
        inputList.add(Arrays.asList(4,2,3,2,1));
        inputList.add(Arrays.asList(4,3,3,4,2));
        inputList.add(Arrays.asList(4,4,4,4,2));

        System.out.println(counter(inputList));

        /*
        1 2 1 1 1
        3 3 3 1 1
        4 2 3 2 1
        3 3 3 4 4
        4 4 4 4 4
         */
        inputList.clear();
        inputList.add(Arrays.asList(1,2,1,1,1));
        inputList.add(Arrays.asList(3,3,3,1,1));
        inputList.add(Arrays.asList(4,2,3,2,1));
        inputList.add(Arrays.asList(3,3,3,4,4));
        inputList.add(Arrays.asList(4,4,4,4,4));
        System.out.println(counter(inputList));

        /*
        1 2 1 1 1 1 1 2 3
        3 3 3 1 1 1 1 2 3
        4 2 3 2 1 1 1 2 2
        3 3 3 4 4 1 1 2 3
        4 4 4 4 4 1 1 1 1
         */
        inputList.clear();
        inputList.add(Arrays.asList(1,2,1,1,1,1,1,2,3));
        inputList.add(Arrays.asList(3,3,3,1,1,1,1,2,3));
        inputList.add(Arrays.asList(4,2,3,2,1,1,1,2,2));
        inputList.add(Arrays.asList(3,3,3,4,4,1,1,2,3));
        inputList.add(Arrays.asList(4,4,4,4,4,1,1,1,1));
        System.out.println(counter(inputList));
    }

    public static int counter(List<List<Integer>> list){
        for(List<Integer> innerList:list)
            System.out.println(innerList);

        if(list.size() == 0)
            System.out.println("Wrong input format");

        Integer[][] inputArray = new Integer[list.size()][];
        Integer[][] counterArray = new Integer[list.size()][list.get(0).size()];
        int i = 0;
        for(List<Integer> innerList: list){
            inputArray[i] = (Integer[]) innerList.toArray();
            for(int j = 0; j < innerList.size(); j++)
                counterArray[i][j] = 0;
            i++;
        }

        int cellValue = inputArray[0][0];
        int counter = 1;


        for(i = 0; i < inputArray.length; i++)
            for(int j = 0; j < inputArray[0].length; j++){
                if(counterArray[i][j] == 0) {
                    //System.out.println("********************************");
                    counterArray[i][j] = 1;
                    filler(inputArray, counterArray, i, j, counter);
                    counter++;
                }
            }
        //System.out.println(Arrays.deepToString(inputArray));
        //System.out.println("********************************");
        //System.out.println(Arrays.deepToString(counterArray));
        //System.out.println("counter = " + --counter);
            return --counter;
    }

    public static void filler(Integer[][] inputArray, Integer[][] counterArray, int i, int j, int counter){
        int cellValue = inputArray[i][j];

        if(j > 0 && (counterArray[i][j - 1]) == 0 && inputArray[i][j - 1] == cellValue){
            counterArray[i][j - 1] = 1;
            filler(inputArray, counterArray, i, j - 1, counter);
        }
        if(i > 0 && (counterArray[i - 1][j]) == 0 && inputArray[i - 1][j] == cellValue){
            counterArray[i - 1][j] = 1;
            filler(inputArray, counterArray, i - 1, j, counter);
        }
        if(j < (counterArray[0].length - 1) && (counterArray[i][j + 1]) == 0 && inputArray[i][j + 1] == cellValue){
            counterArray[i][j + 1] = 1;
            filler(inputArray, counterArray, i, j + 1, counter);
        }
        if(i < (counterArray.length - 1) && (counterArray[i + 1][j]) == 0 && inputArray[i + 1][j] == cellValue){
            counterArray[i + 1][j] = 1;
            filler(inputArray, counterArray, i + 1, j, counter);
        }

        //System.out.println(Arrays.deepToString(counterArray));
    }
    
}