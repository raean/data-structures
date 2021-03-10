/**
 * In this class, I will be testing out three different
 * implementations of the classic Fibonacci sequence:
 * A recursive approach, a memo-ized approach and a
 * bottom-up approach.
 */
public class Fibonacci {
    
    // Regular recursion method:
    public static int fib(int n) {
        int result;
        if (n == 1 || n == 2) {
            result = 1;
        } else {
            result = fib(n-1) & fib(n-2);
        }
        return result;
    }

    // Memo-ized version:
    public static int fibMemo(int n, int[] memo) {
        if (memo[n] != 0) {
            return memo[n];
        } 

        int result;
        if (n == 1 || n == 2) {
            result = 1;
        } else {
            result = fibMemo(n-1, memo) + fibMemo(n-2, memo);
        }
        return result;
    }

    // Bottom-up version:
    public static int fibBottomUp(int n) {
        
        int[] allResults = new int[n+1];

        allResults[0] = 1;
        allResults[1] = 1;

        for (int i = 2 ; i <= n ; i++) {
            allResults[i] = allResults[i-1] + allResults[i-2];
        }

        return allResults[n];
    }

    // Testing the time elapsed and outputs of each method:
    public static void main(String[] args) {
        // Testing recursive Fibonacci at n = 5, n = 35 & n = 100:
        long start = System.nanoTime();
        System.out.println("fib() of 5: " + fib(5));
        long end = System.nanoTime();
        System.out.println("Time elpased: " + (end - start)/1000000); 
        System.out.println("------"); 
        start = System.nanoTime();
        System.out.println("fib() of 35: " + fib(35));
        end = System.nanoTime();
        System.out.println("Time elpased: " + (end - start)/1000000); 
        System.out.println("------"); 
        // System.out.println("fib() of 100: " + fib(100));
        // end = System.nanoTime();
        // System.out.println("Time elpased: " + (end - start)/1000000000); 
        // System.out.println("------"); 
        // n = 100 takes too long on my machine - careful :)!
        

        // Testing memo-ized Fibonacci at n = 5, n = 35 & n = 50;
        start = System.nanoTime();
        System.out.println("Fib() of 5: " + fibMemo(5, new int[6]));
        end = System.nanoTime();
        System.out.println("Time elpased: " + (end - start)/1000000); 
        System.out.println("------"); 
        start = System.nanoTime();
        System.out.println("fibMemo() of 35: " + fibMemo(35, new int[36]));
        end = System.nanoTime();
        System.out.println("Time elpased: " + (end - start)/1000000); 
        System.out.println("------"); 
        System.out.println("fibMemo() of 100: " + fibMemo(100, new int[101]));
        end = System.nanoTime();
        System.out.println("Time elpased: " + (end - start)/1000000); 
        System.out.println("------"); 

        // Testing bottom-up Fibonacci at n = 5, n = 35 & n = 100
        start = System.nanoTime();
        System.out.println("fibBottomUp() of 5: " + fibBottomUp(5));
        end = System.nanoTime();
        System.out.println("Time elpased: " + (end - start)/1000000); 
        System.out.println("------"); 
        start = System.nanoTime();
        System.out.println("fibBottomUp() of 35: " + fibBottomUp(35));
        end = System.nanoTime();
        System.out.println("Time elpased: " + (end - start)/1000000); 
        System.out.println("------"); 
        System.out.println("fibBottomUp() of 100: " + fibBottomUp(100));
        end = System.nanoTime();
        System.out.println("Time elpased: " + (end - start)/1000000); 
        System.out.println("------"); 
    }
}
