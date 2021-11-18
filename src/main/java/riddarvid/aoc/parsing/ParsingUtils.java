package riddarvid.aoc.parsing;

import java.util.ArrayList;
import java.util.List;

public class ParsingUtils {
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

    public static List<Integer> stringsToIntegers(List<String> input) {
        List<Integer> integers = new ArrayList<>();
        for (String s : input) {
            integers.add(Integer.parseInt(s));
        }
        return integers;
    }

    public static List<Long> stringsToLongs(List<String> input) {
        List<Long> longs = new ArrayList<>();
        for (String s : input) {
            longs.add(Long.parseLong(s));
        }
        return longs;
    }

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
