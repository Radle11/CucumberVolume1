package jPractice;

public class BalanceParentheses {
    public static int minNum(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        for (int i = 0; i <stringBuilder.length()-1 ; ){
            if (stringBuilder.charAt(i)=='('&&stringBuilder.charAt(i+1)==')'){
                stringBuilder.delete(i,i+1);
                stringBuilder.delete(i+1,i+2);
                i=0;
            }else {
                i++;
            }
        }
        return stringBuilder.length();
    }

    public static void main(String[] args) {
        System.out.println(minNum("(()))))(((((((()))))(()()()()())))()()()))(("));

    }
}
