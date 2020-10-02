package jPractice;

import java.util.ArrayList;
import java.util.List;

public class listCheck {
   static List<String> list;
 static void addList(){
    list=new ArrayList<>();

    list.add("str");
}
    public static void main(String[] args) {
     addList();
        System.out.println(list);
    }
}
