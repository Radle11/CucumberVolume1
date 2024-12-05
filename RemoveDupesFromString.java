package jPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveDupesFromString {
    public static String removeDups(String word) {
        Set<Character> chars = new HashSet<>();
        StringBuilder output = new StringBuilder(word.length());
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (chars.add(ch)) {
                output.append(ch);
            }
        }
        return output.toString();
    }
    public static String removeDupsInPlace(String word) {
        final StringBuilder output = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            String character = word.substring(i, i + 1);
            if (output.indexOf(character) < 0) // if not contained
         output.append(character);
    }
    return output.toString();
    }
    public static String removeDupsStream(String word) {
       String result = Arrays.asList(word.split(""))
                .stream()
                .distinct()
                .collect(Collectors.joining());
        return result;
    }
    public static void main(String[] args) {
        System.out.println(removeDups("beekeeper"));
        System.out.println(removeDupsInPlace("beekeeper"));
        System.out.println(removeDupsStream("beekeeper"));
     
    }
}