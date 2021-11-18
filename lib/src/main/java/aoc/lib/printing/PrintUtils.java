package aoc.lib.printing;

/**
 * A collection of static printing utilities.
 */
public class PrintUtils {
    /**
     * Prints a char matrix in a readable way.
     * @param matrix The matrix to be printed.
     */
    public static void printCharMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            System.out.println(new String(chars));
        }
    }
}
