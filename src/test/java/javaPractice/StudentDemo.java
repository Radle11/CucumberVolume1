/*
package javaPractice;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StudentDemo {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(new Student(110, "Rahul",true),
                new Student(20, "Ash",true),
                new Student(40, "Rakesh",false),
                new Student(50, "Srikanth",true),
                new Student(60, "Howard",true),
                new Student(80, "Kim",false),
                new Student(90, "Ziao",true),
                new Student(30, "Sandesh",false));
//        students.forEach(System.out::println);
//List<Student> students1=students.stream().sorted(Comparator.comparingInt(Student::getStudentID)).collect(Collectors.toList());
//        students1.forEach(System.out::println);



        students.sort(Comparator.comparing(i->
        {
            if (i.getExam().booleanValue()==true)

        }));

        students.forEach(System.out::println);

       */
/* Collections.sort(myList, new Comparator<MyObject>() {
            @Override
            public int compare(MyObject a, MyObject b) {
                int cmp0 = a.getAttributeX().compareTo(b.getAttributeX());
                if (cmp0 != 0) {
                    return cmp0;
                }
                int cmp1 = a.getSomething().getSubValue().compareTo(b.getSomething().getSubValue());
                if (cmp1 != 0) {
                    return cmp1;
                }
                return a.getInt() - b.getInt();
            }
        });*//*

    }
}
*/
