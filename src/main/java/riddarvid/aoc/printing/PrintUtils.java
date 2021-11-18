package riddarvid.aoc.printing;

public class PrintUtils {
    public static void printCharMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            System.out.println(new String(chars));
        }
    }
}
