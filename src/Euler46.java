
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
 * Answer: 5777
 */

import java.util.ArrayList;

public class Euler46 {

    
    static ArrayList<Integer> p = new ArrayList<>();
    
    public static void main(String[] args) {

        long startTime = System.nanoTime();

        boolean found = true; // Found numbers that satisfy the conjecture
        int n = 1;
        p.add(2);
        while (found) {
            n += 2;
            if (isPrime(n)) {
                p.add(n);
            } 
            else {    // it is a composite
                found = false;
                for (Integer pp : p) {
                    double v = (n-pp)/2.0;
                    int v2 = (int) Math.sqrt(v) ;
                    if ( v-v2*v2 == 0) {
                        System.out.printf("%3d = %3d + 2*%3d^2\n", n, pp, (int) Math.sqrt(v));
                        found = true;
                        break;
                    }
                }
            }
        }
        if (!found)
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
