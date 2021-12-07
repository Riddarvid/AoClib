package aoc.days;

import java.io.InputStream;
import java.util.List;

/**
 * A class used to reduce boilerplate code for reading inputs and executing solutions.
 */
public abstract class Day {
    /**
     * The constructor will populate this list with the contents of each row of the input.
     */
    protected List<String> lines;

    private void readLines(String fileName) {
        InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);
        if (is == null) {
            System.out.println("No such file found: " + fileName);
        } else {
            lines = FileUtils.getLines(is);
        }
    }

    /**
     * Executes the abstract methods setup, part1 and part2.
     */
    public void run(String fileName) {
        readLines(fileName);
        setup();
        part1();
        part2();
    }

    /**
     * Same as run, but prints the result of part1 and part2.
     */
    public void runAndPrint(String fileName) {
        readLines(fileName);
        setup();
        System.out.println(part1());
        System.out.println(part2());
    }

    /**
     * Optional method for preparing data.
     */
    public abstract void setup();

    /**
     * Executes the first part of the solution.
     * @return The answer for the first part of the solution.
     */
    public abstract long part1();

    /**
     * Executes the second part of the solution.
     * @return The answer for the second part of the solution.
     */
    public abstract long part2();
}
