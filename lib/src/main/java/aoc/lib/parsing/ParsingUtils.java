package aoc.lib.parsing;

import java.util.ArrayList;
import java.util.List;

/**
 * A collection of static parsing utilities.
 */
public class ParsingUtils {
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
        int start = 0;
        List<Integer> integers = new ArrayList<>();
        while (start < input.length()) {
            while (start < input.length() && !Character.isDigit(input.charAt(start))) {
                start++;
            }
            if (start >= input.length()) {
                break;
            }
            int end = start + 1;
            while (end < input.length() && Character.isDigit(input.charAt(end))) {
                end ++;
            }
            integers.add(Integer.parseInt(input.substring(start, end)));
            start = end + 1;
        }
        return integers;
    }

    /**
     * Finds all the positive longs in a string.
     * @param input The string to search.
     * @return All positive longs found.
     */
    public static List<Long> getLongs(String input) {
        int start = 0;
        List<Long> longs = new ArrayList<>();
        while (start < input.length()) {
            while (start < input.length() && !Character.isDigit(input.charAt(start))) {
                start++;
            }
            if (start >= input.length()) {
                break;
            }
            int end = start + 1;
            while (end < input.length() && Character.isDigit(input.charAt(end))) {
                end ++;
            }
            longs.add(Long.parseLong(input.substring(start, end)));
            start = end + 1;
        }
        return longs;
    }

    /**
     * Finds all the integers in a string.
     * @param input The string to search.
     * @return All integers found.
     */
    public static List<Integer> getIntegersNegative(String input) {
        int start = 0;
        List<Integer> integers = new ArrayList<>();
        while (start < input.length()) {
            while (start < input.length() && !Character.isDigit(input.charAt(start)) && input.charAt(start) != '-') {
                start++;
            }
            if (start >= input.length()) {
                break;
            }
            boolean negative = false;
            int end = start + 1;
            while (end < input.length() && Character.isDigit(input.charAt(end))) {
                end ++;
            }
            int toBeAdded = Integer.parseInt(input.substring(start, end));
            integers.add(toBeAdded);
            start = end + 1;
        }
        return integers;
    }

    /**
     * Tokenizes a string based on the given delimiter.
     * @param input The string to tokenize.
     * @param delimiter The delimiter used in tokenizing the string.
     * @return A list of tokens.
     */
    public static List<String> getTokens(String input, char delimiter) {
        int start = 0;
        List<String> tokens = new ArrayList<>();
        while (start < input.length()) {
            while (start < input.length() && input.charAt(start) == delimiter) {
                start++;
            }
            if (start >= input.length()) {
                break;
            }
            int end = start + 1;
            while (end < input.length() && input.charAt(end) != delimiter) {
                end ++;
            }
            tokens.add(input.substring(start, end));
            start = end + 1;
        }
        return tokens;
    }
}
