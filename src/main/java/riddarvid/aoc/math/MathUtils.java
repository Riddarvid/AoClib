package riddarvid.aoc.math;

import java.util.List;

public class MathUtils {
    public static boolean inRange(int low, int high, int n) {
        return n >= low && n <= high;
    }

    public static long product(List<Integer> ns) {
        long product = 1;
        for (int n : ns) {
            product *= n;
        }
        return product;
    }
}
