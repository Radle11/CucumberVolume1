package jPractice;

import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class splitInteger {
    static List<Integer> split(Integer x, Integer n) {
        List<Integer> result=new ArrayList<>();
        if (x % n == 0) {
            for (int i = 0; i < n; i++)
                result.add(x / n);
        } else {
            int zp = n - (x % n);
            int pp = x / n;
            for (int i = 0; i < n; i++) {

                if (i >= zp)
                    result.add(pp + 1);
                else
                    result.add(pp);
            }
        }
        return result;
    }
        public static void main(String[] args)
        {

            int x =11;
            int n = 3;
            System.out.println(split(x, n));

        }

}
