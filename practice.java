package jPractice;

import java.util.*;
class practice{
	public static void main(String []args){
	System.out.println(getLetterCount("Emphasis"));
	System.out.println(getLetterCountMapMerge("Elefant"));
    System.out.println("The reversed string is: " + reverseString("Welcome to Beginnersbook"));
    System.out.printf("The reversed string is  %s", reverseString2("Techtorial"));
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
	static  Map<Character,Integer> getLetterCountMapMerge(String str){
		Map<Character,Integer> result=new HashMap<>();
		for(char c:str.toCharArray()){
			result.merge(c,1,Integer::sum);
		}
		result.entrySet().stream().forEach(k->System.out.printf("%s->%s%n",k.getKey(),k.getValue()));
		return result;
	}

	static String reverseString(String str){
		 if (str.isEmpty())
            return str;
        return reverseString(str.substring(1)) + str.charAt(0);
         // System.out.print(str.charAt(str.length()-1)); 
         //    reverseString(str.substring(0,str.length()-1));
	}
	static String reverseString2(String str){
        String reverse="";
        int i=str.length()-1;
        while(i>=0){
            reverse+=str.charAt(i--);
        }
        return String.format("%s->%s",str,reverse);
    }
}