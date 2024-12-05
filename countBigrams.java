package jPractice;

import java.util.ArrayList;
import java.util.LinkedHashMap;

class countBigrams {
    public static void main(String[] args) {
        String givenStr = "The quick brown fox and the quick blue hare.";
        String str = givenStr.substring(0, givenStr.length() - 1).toLowerCase();
        String[] arr = str.split(" ");
        ArrayList<String> bigrams = new ArrayList<>();
        String s1 = "";
        String s2 = "";
        String s3 = "";
        for (int i = 0; i < arr.length - 1; i++) {
            s1 = arr[i];
            s2 = arr[i + 1];
            s3 = s1 + " " + s2;
            bigrams.add(s3);
        }
LinkedHashMap<String, Integer> countBigrams = new LinkedHashMap<>();
        for(String bigram:bigrams){
            if (countBigrams.containsKey(bigram)){
                int count = countBigrams.get(bigram);
                countBigrams.replace(bigram, ++count);
            } else
                countBigrams.put(bigram, 1);
        }
        System.out.println(countBigrams);
    }
}