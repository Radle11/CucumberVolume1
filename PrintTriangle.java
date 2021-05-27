package jPractice;

public class PrintTriangle {
    static void triangle(int n)
    {
        // number of spaces
        int k = 2 * n - 2;

        // character to be printed
        int ch = 1;

        // outer loop to handle number of rows
        // n in this case
        for (int i = 0; i < n; i++)
        {

            // inner loop to handle number spaces
            // values changing acc. to requirement
            for (int j = 0; j < k; j++)
                System.out.print(" ");

            // decrementing k after each loop
            k = k - 1;

            // inner loop to handle number of columns
            // values changing acc. to outer loop
            for (int j = 0; j <= i; j++)
            {
                // printing stars
                System.out.print(ch++ + " ");
            }

            // ending line after each row
            System.out.println();
        }
    }

    // Function to find the max height
// or the number of lines
// in the triangle pattern
    static int maxHeight(int n)
    {
        return (((int)Math.sqrt(1 + 8.0 * n)) - 1) / 2;
    }

    // Driver Code
    public static void main(String[] args)
    {
        int N = 9;
        triangle(maxHeight(N));
    }

}
