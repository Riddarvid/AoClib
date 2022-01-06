package aoc.parsing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A collection of static parsing utilities.
 */
public class ParsingUtils {
    private static final Pattern positiveIntegersPattern = Pattern.compile("[0-9]+");
    private static final Pattern negativeIntegersPattern = Pattern.compile("-?[0-9]+");

    /**
     * Converts a list of strings into a matrix of booleans.
     * The character trueChar is converted to true, all others are converted to false.
     * @param input The list of strings to be converted.
     * @param trueChar The char that should be converted to true.
     * @return The boolean matrix.
     */
    public static boolean[][] stringsToBoolMatrix(List<String> input, char trueChar) {
        boolean[][] matrix = new boolean[input.size()][];
        for (int line = 0; line < input.size(); line++) {
            String s = input.get(line);
            matrix[line] = new boolean[s.length()];
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == trueChar) {
                    matrix[line][i] = true;
                }
            }
        }
        return matrix;
    }

    /**
     * Converts a list of strings to a list of integers.
     * @param input A list of strings representing integers.
     * @return The list of integers represented by input.
     */
    public static List<Integer> stringsToIntegers(List<String> input) {
        List<Integer> integers = new ArrayList<>();
        for (String s : input) {
            integers.add(Integer.parseInt(s));
        }
        return integers;
    }

    /**
     * Converts a list of strings to a list of longs.
     * @param input A list of strings representing longs.
     * @return The list of longs represented by input.
     */
    public static List<Long> stringsToLongs(List<String> input) {
        List<Long> longs = new ArrayList<>();
        for (String s : input) {
            longs.add(Long.parseLong(s));
        }
        return longs;
    }

    /**
     * Finds all the positive integers in a string.
     * @param input The string to search.
     * @return All positive integers found.
     */
    public static List<Integer> getIntegers(String input) {
        List<Integer> integers = new ArrayList<>();
        Matcher matcher = positiveIntegersPattern.matcher(input);
        while (matcher.find()) {
            integers.add(Integer.parseInt(matcher.group()));
        }
        return integers;
    }

    /**
     * Finds all the positive longs in a string.
     * @param input The string to search.
     * @return All positive longs found.
     */
    public static List<Long> getLongs(String input) {
        List<Long> longs = new ArrayList<>();
        Matcher matcher = positiveIntegersPattern.matcher(input);
        while (matcher.find()) {
            longs.add(Long.parseLong(matcher.group()));
        }
        return longs;
    }

    /**
     * Finds all the integers in a string.
     * @param input The string to search.
     * @return All integers found.
     */
    public static List<Integer> getIntegersNegative(String input) {
        List<Integer> integers = new ArrayList<>();
        Matcher matcher = negativeIntegersPattern.matcher(input);
        while (matcher.find()) {
            integers.add(Integer.parseInt(matcher.group()));
        }
        return integers;
    }

    public static List<String> getTokens(String input, char delimiter) {
        return getTokens(input, "" + delimiter);
    }

    public static List<String> getTokens(String input, String regex) {
        String[] tokenArray = input.split(regex);
        return Arrays.asList(tokenArray);
    }
}
