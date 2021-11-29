package aoc.math;

import java.util.List;

/**
 * A collection of static math utilities.
 */
public class MathUtils {
    /**
     * Determines whether n is in the range low-high inclusive.
     * @param low Lower bound.
     * @param high Upper bound.
     * @param n The value to be examined.
     * @return True if n lies between low-high inclusive.
     */
    public static boolean inRange(int low, int high, int n) {
        return n >= low && n <= high;
    }

    /**
     * Calculates the products of all the integers in ns.
     * @param ns The integers to be multiplied.
     * @return The product of all integers in ns.
     */
    public static long product(List<Integer> ns) {
        long product = 1;
        for (int n : ns) {
            product *= n;
        }
        return product;
    }

    /**
     * Calculates the sum of all the integers in ns.
     * @param ns The integers to be summed.
     * @return The sum of all integers in ns.
     */
    public static long sum(List<Integer> ns) {
        long sum = 0;
        for (int n : ns) {
            sum += n;
        }
        return sum;
    }

    /**
     * Calculates the products of all the integers in ns.
     * @param ns The integers to be multiplied.
     * @return The product of all integers in ns.
     */
    public static long productLongs(List<Long> ns) {
        long product = 1;
        for (long n : ns) {
            product *= n;
        }
        return product;
    }

    /**
     * Calculates the sum of all the longs in ns.
     * @param ns The longs to be summed.
     * @return The sum of all longs in ns.
     */
    public static long sumLongs(List<Long> ns) {
        long sum = 0;
        for (long n : ns) {
            sum += n;
        }
        return sum;
    }
}
