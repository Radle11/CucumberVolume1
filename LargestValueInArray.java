package jPractice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class LargestValueInArray {
    public static void main(String[] args) {
        int[] arr={1,9,7,6,4,-10,1};
        System.out.println(Arrays.toString(twoLargest(arr)));
        int[][] dArr={{1,2,3,4,5,6,7},{1,3,3,4,5,4,5,6}};
        System.out.println(Arrays.deepToString(dArr));
        for (int[] dd:dArr){
            for (int d:dd){
                System.out.print(d);
            }
            System.out.println();
        }


    }
    public static int[] twoLargest(int values[]){
        int largestA = Integer.MIN_VALUE, largestB = Integer.MIN_VALUE;

        for(int value : values) {
            if(value > largestA) {
                largestB = largestA;
                largestA = value;
            } else if (value > largestB) {
                largestB = value;
            }
        }
        return new int[] { largestA, largestB };
    }
    static void twoLargest(Object[] arr){
        Arrays.sort(arr);
        Object[] result=new Object[2];
        result[0]=arr[arr.length-1];
        result[1]=arr[arr.length-2];
        System.out.println(Arrays.toString(result));
    }

}
