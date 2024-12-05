package jPractice;

import java.util.*;
import java.util.stream.IntStream;
class practice2{

public static void main(String []args){
System.out.println(countLetter("applebees"));
System.out.println(reverseStr("Hello Java"));
System.out.println(isAnagram("listen","silent"));
System.out.println(isPolindrom("civic"));
System.out.println(isPal("civic"));
//IntStream.rangeClosed(1,100).forEach(System.out::println);
}
public static Map<Character,Integer> countLetter(String str){
	Map<Character,Integer> result=new HashMap<>();
		for(char c:str.toCharArray()){
			result.merge(c,1,Integer::sum);
		}
		result.entrySet().stream().forEach(k->System.out.printf("%s->%s%n",k.getKey(),k.getValue()));
		return result;
}
static String reverseStr(String str){
	if(str.isEmpty())
		return str;
	return reverseStr(str.substring(1))+str.charAt(0);
	
}
static boolean isAnagram(String str1, String str2){
	char[] str1Char=str1.toCharArray();
	char[] str2Char=str2.toCharArray();
	Arrays.sort(str1Char);
	Arrays.sort(str2Char);
	if(Arrays.equals(str1Char,str2Char))
		return true;
	return false;
}
static boolean isPolindrom(String str){
	if(str.equals(reverseStr(str)))
		return true;
	return false;
}
 public static boolean isPal(String s)
    {   // if length is 0 or 1 then String is palindrome
        if(s.length() == 0 || s.length() == 1)
            return true; 
        if(s.charAt(0) == s.charAt(s.length()-1))
        /* check for first and last char of String:
         * if they are same then do the same thing for a substring
         * with first and last char removed. and carry on this
         * until you string completes or condition fails
         * Function calling itself: Recursion
         */
        return isPal(s.substring(1, s.length()-1));

        /* If program control reaches to this statement it means
         * the String is not palindrome hence return false.
         */
        return false;
    }

}