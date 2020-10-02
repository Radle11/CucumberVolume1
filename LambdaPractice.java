package jPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LambdaPractice {
    public static void main(String[] args) {
        List<String> pointList = new ArrayList();
        pointList.add("1");
        pointList.add("2");

        pointList.forEach(p -> {
                    System.out.println(p);
                    //Do more work
                }
        );
        new Thread(() -> System.out.println("My Runnable")).start();

        System.out.println("=============================");
        Employee[] employees = {
                new Employee("David"),
                new Employee("Naveen"),
                new Employee("Alex"),
                new Employee("Richard")};

        System.out.println("Before Sorting Names: " + Arrays.toString(employees));
        Arrays.sort(employees, Employee::nameCompare);
        System.out.println("After Sorting Names " + Arrays.toString(employees));
        System.out.println("=============================");

        IntStream stream = IntStream.range(1, 5);
        stream.forEach(System.out::println);
        IntStream.iterate(0, i -> i + 2).limit(10);
        System.out.println("=============================");
        IntStream closedRangeStream = IntStream.rangeClosed(5, 10);
        closedRangeStream.forEach(System.out::println);   //5,6,7,8,9,10

        System.out.println("=============================");
        IntStream stream1 = IntStream.generate(()
                -> {
            return (int) (Math.random() * 10000);
        });

        stream1.limit(10).forEach(System.out::println);
        System.out.println("========================");
        IntStream stream2 = IntStream.range(1, 100);

        List<Integer> primes = stream2.filter(LambdaPractice::isPrime)
                .boxed()
                .collect(Collectors.toList());

        System.out.println(primes);
        System.out.println("==============================");
        int[] intArray = IntStream.of(1, 2, 3, 4, 5).toArray();
        System.out.println(Arrays.toString(intArray));
        System.out.println("===================================");
        List<Integer> ints = IntStream.of(1,2,3,4,5)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(ints);



    }

    public static boolean isPrime(int i)
    {
        IntPredicate isDivisible = index -> i % index == 0;
        return i > 1 && IntStream.range(2, i).noneMatch(isDivisible);
    }



}

class Employee {
    String name;

    Employee(String name) {
        this.name = name;
    }

    public static int nameCompare(Employee a1, Employee a2) {
        return a1.name.compareTo(a2.name);
    }

    public String toString() {
        return name;
    }
}
