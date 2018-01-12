
/**
 * https://projecteuler.net/problem=46
 * Goldbach's other conjecture
 * Problem 46 
 * It was proposed by Christian Goldbach that every odd composite number can be 
 * written as the sum of a prime and twice a square.
 * 9 = 7 + 2×1^2
 * 15 = 7 + 2×2^2
 * 21 = 3 + 2×3^2
 * 25 = 7 + 2×3^2
 * 27 = 19 + 2×2^2
 * 33 = 31 + 2×1^2
 * It turns out that the conjecture was false.
 * 
 * What is the smallest odd composite that cannot be written as the sum of a prime and twice a square?
 * 
 * If it helps your program, you can rely on the fact the result number is smaller than 6000.
 * 
 * Answer: ____5777____  <== You fill in (you can check on Euler Project)
 */

import java.util.ArrayList;

public class Euler46 {

    
    public static void main(String[] args) {

        long startTime = System.nanoTime();

        int n=1;

        // ToDo: Your code here  
        // You are welcome to use the isPrime function below.
        boolean found = true;
        while (found) {
            n += 2;
            if (!isPrime(n)) {
                found = false;
                System.out.print(n + " = ");
                for (int i=1; i*i*2<n && !found; ++i) {
                    if (isPrime(n-(2*i*i))) {
                        int d = n-(2*i*i);
                        found = true;
                        System.out.println(d + "+2*" + i + "^2");
                    }
                }
            }
        }
        
        System.out.printf("Doesn't work for n=%3d!! done.\n", n);
        
        long elapsedTime = System.nanoTime() - startTime;

        System.out.printf("*** Euler46:: Time=%d [msec]\n",(elapsedTime / (long) 1e6));

    }
    
    
    public static boolean isPrime(int n) {
        if (n==1) return false;
        for (int ii=2; ii<=Math.sqrt(n); ++ii)
            if (n%ii ==0)
                return false;
        return true;
    }
    
    
    
    
    
}
