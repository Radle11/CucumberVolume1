package jPractice;

import java.util.*;
import java.util.logging.Logger;

import static java.util.stream.Collectors.toMap;

public class Main {

    public static void main(String[] args) {
        //count number occurrence
        int[] arr={1,2,3,4,4,2,8,7,4,6};
        HashMap<Integer, Integer> intMap = new HashMap<>();
        int count;
        for(int i=0;i<arr.length;i++){
//            if(intMap.get(arr[i])==null){
//                intMap.put(arr[i],1);
//            }else{
//                count=intMap.get(arr[i]);
//                count++;
//                intMap.put(arr[i],count);
            if (intMap.containsKey(intMap.get(arr[i]))) {
                intMap.put(arr[i], intMap.get(arr[i]) + 1);
            }
            else {
                intMap.put(arr[i], 1);
            }
//            }
        }
        System.out.println(intMap);


//count letter occurrence
        String str="Hello";
        HashMap<Character, Integer> strMap = new HashMap<>();
        char[] strArray = str.toCharArray();
        for (char c : strArray) {
            if (strMap.containsKey(c)) {
                strMap.put(c, strMap.get(c) + 1);
            }
            else {
                strMap.put(c, 1);
            }
        }
        System.out.println(strMap);

  //Map.merge()
        String s = "abcaba";
        Map<Character, Integer> freqs = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqs.merge(c,                  // key = char
                    1,                  // value to merge
                    Integer::sum);      // counting
        }
        freqs.entrySet().stream().forEach(k->System.out.printf("%s->%s%n",k.getKey(),k.getValue()));
        System.out.println("Frequencies:\n" + freqs);
        System.out.println(freqs.keySet());
        System.out.println(freqs.entrySet());
        //////////////////////////////////////////////////////
        System.out.println(getLetterCount("emphasis"));
    }

    static HashMap<Character,Integer> getLetterCount(String str){
        HashMap <Character,Integer> countResult=new HashMap<>();
        for(int i=0;i<=str.length()-1;i++){
            if(countResult.containsKey(str.charAt(i))){
                countResult.put(str.charAt(i),countResult.get(str.charAt(i))+1);
            }else{
                countResult.put(str.charAt(i),1);
            }
        }
        return countResult;
    }
    static void getLetterSteam(){
        String s = "abcaba";
        Map<Character, Integer> frequencies = s.chars().boxed()
                .collect(toMap(
                        // key = char
                        k -> Character.valueOf((char) k.intValue()),
                        v -> 1,         // 1 occurence
                        Integer::sum)); // counting
        System.out.println("Frequencies:\n" + frequencies);
    }



    private static int countOccurences(
            String someString, char searchedChar, int index) {
        if (index >= someString.length()) {
            return 0;
        }

        int count = someString.charAt(index) == searchedChar ? 1 : 0;
        return count + countOccurences(
                someString, searchedChar, index + 1);
    }

}