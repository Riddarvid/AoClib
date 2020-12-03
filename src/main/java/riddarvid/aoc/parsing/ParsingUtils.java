package riddarvid.aoc.parsing;

import java.util.ArrayList;
import java.util.List;

public class ParsingUtils {
    public static List<Integer> stringsToIntegers(List<String> input) {
        List<Integer> integers = new ArrayList<>();
        for (String s : input) {
            integers.add(Integer.parseInt(s));
        }
        return integers;
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
