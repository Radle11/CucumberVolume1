package jPractice;

import jdk.internal.org.objectweb.asm.tree.analysis.Interpreter;

import javax.swing.*;
import java.beans.Expression;
import java.util.stream.IntStream;

public class practiceT {
    public static void main(String[] args) {
//        for(int i = 1; i<=100; i++){
//            String value = i%3==0 ? i%5==0 ? "Elmurat Ismailov" : "Elmurat" : i%5==0 ? "Ismailov" : ""+i;
//            System.out.println(value);
//        }

//        IntStream.rangeClosed(1, 100)
//                .mapToObj(i -> i % 3 == 0 ? (i % 5 == 0 ? "FizzBuzz" : "Fizz") : (i % 5 == 0 ? "Buzz" : i))
//                .forEach(System.out::println);



//        IntStream.range(1,100).mapToObj(i->i%3==0?(i%5==0?"FizzBuzz":"Buzz"):(i % 5 == 0 ? "Fizz":i))
//                .forEach(System.out::println);


//        IntStream.rangeClosed(1, 5).map(x -> 6-x)
//                .forEach(System.out::println);



        String str="19 * 2=";
        int firstinteger= Integer.parseInt(str.contains("+")?str.substring(0,str.indexOf('+')).trim():
                (str.contains("-")?str.substring(0,str.indexOf('-')).trim():
                        (str.contains("*")?str.substring(0,str.indexOf('*')).trim():
                                str.contains("/")?str.substring(0,str.indexOf('/')).trim():
                                        str
                                )));
        int secondinteger= Integer.parseInt(str.substring(str.contains("+")?str.indexOf('+')+1:
                (str.contains("-")?str.indexOf('-')+1:
                        str.contains("*")?str.trim().indexOf('*')+1:
                            str.contains("/")?str.trim().indexOf('/')+1:0), str.indexOf('=')).trim());
        int result=str.contains("+")?firstinteger+secondinteger:
                (str.contains("-")?firstinteger-secondinteger:
                        (str.contains("*")?firstinteger*secondinteger:
                                (str.contains("/")?firstinteger/secondinteger:-1)));
        System.out.println(result);
        }

}
