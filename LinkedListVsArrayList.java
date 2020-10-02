package jPractice;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.LinkedList;

public class LinkedListVsArrayList {
    @Test
    public void checkArrayList(){
        ArrayList<Integer> link=new ArrayList<>();
        long startTime=System.currentTimeMillis();
        for(int i=0;i<=1000000;i++){
            link.add(i);
        }
        long endTime=System.currentTimeMillis();
        System.out.println(endTime-startTime);
        System.out.println(link.size());
    }
    @Test
    public void checkLinkedList(){
        LinkedList<Integer> link=new LinkedList<Integer>();
        long startTime=System.currentTimeMillis();
        for(int i=0;i<=1000000000;i++){
            link.add(i);
        }
        long endTime=System.currentTimeMillis();
        System.out.println(endTime-startTime);
        System.out.println(link.size());
    }

}
