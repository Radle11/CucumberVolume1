package jPractice;

import java.util.HashMap;
import java.util.Map;

public class AmazonAirport {
    public static void main(String[] args) {
// Day runs from minute 0 to minute 1440 (exclusive)
// Input: example 9:30 => 570
// arr [570, 675, 990]
// dept [705, 690, 1005]
// Assume data is valid - i.e. length, no neg, etc.

        int[] arr = { 570, 675, 990 };
        int[] dept = { 705, 690, 1005 };

// Create a frequency map for the day
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int n = 0; n < arr.length; n++) {
            int a = arr[n];
            int d = dept[n];
            for (int i = a; i < d; i++) {
                int count = freqMap.containsKey(i) ? freqMap.get(i) : 0;
                freqMap.put(i, count + 1);
            }
        }

// Calculate the max value
        int maxVal = 0;
        for (Integer n : freqMap.values()) {
            if (n > maxVal) {
                maxVal = n;
            }
        }

        System.out.println("Gates needed: " +maxVal);
    }
}
