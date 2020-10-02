package jPractice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class isContaisString {
    public static void main(String args[] ) throws Exception {
        String inputData = "";
        String thisLine = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while ((thisLine = br.readLine()) != null) {
            inputData += thisLine + "\n";
        }
        // Output the solution to the console
        System.out.println(codeHere(inputData));
    }
    public static String codeHere(String inputData) {
        // Use this function to write your solution;
        return inputData;
    }
}
