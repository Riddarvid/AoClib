package aoc.days;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

/**
 * A class used to reduce boilerplate code for reading inputs and executing solutions.
 */
public abstract class Day {
    /**
     * The constructor will populate this list with the contents of each row of the input.
     */
    protected List<String> lines;
    private static final String DEFAULT_FILE_NAME = "input";

    /**
     * Reads the input file located at the same level as the class extending this one.
     */
    public Day(String fileName) {
        InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);
        if (is == null) {
            System.out.println("No such file found: " + fileName);
        } else {
            lines = FileUtils.getLines(is);
        }
    }

    /**
     * Reads the input file located at the same level as the class extending this one.
     */
    public Day() {
        this(DEFAULT_FILE_NAME);
    }

    /**
     * Executes the abstract methods setup, part1 and part2.
     */
    public void run() {
        setup();
        part1();
        part2();
    }

    /**
     * Same as run, but prints the result of part1 and part2.
     */
    public void runAndPrint() {
        setup();
        System.out.println(part1());
        System.out.println(part2());
    }

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


    /**
     * Optional method for preparing data.
     */
    public abstract void setup();
}
