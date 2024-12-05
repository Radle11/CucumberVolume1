package jPractice;

public class FibonacciNumber {
    public static void main(String[] args) {
        System.out.println(isAlphabet('*'));
        System.out.println(reverseInt(-123));
        System.out.println(naturalNumb(100));
        System.out.println(factorialNumber(10));
        System.out.println(pythagorasTable(3));

    }
     static String isAlphabet(char c){
        String output = (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')
                ? c + " is an alphabet."
                : c + " is not an alphabet.";
        return output;
    }
    static int reverseInt(int n){
        int r=0;
        while (n!=0){
            int d=n%10;
            r=r*10+d;
            n/=10;
        }
        return r;
    }
    static int naturalNumb(int n){
        int sum=0;
        while(n!=0){
            sum+=n--;
        }
        return sum;
    }
    static int factorialNumber(int n){
        int factorial=1;
        while(n!=0){
            factorial=factorial*n--;
        }
        return factorial;
    }
    @Override
    public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }
    static String pythagorasTable(int numb){
        String[]p=new String [11];
        for(int i = 0; i <= 10; ++i) {

            p[i]=String.format("%d * %d = %d \n", numb, i, numb * i);
        }
        return p.toString();
    }
}
