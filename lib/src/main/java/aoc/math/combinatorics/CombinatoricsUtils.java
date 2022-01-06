package aoc.math.combinatorics;

import java.util.ArrayList;
import java.util.List;

public class CombinatoricsUtils {
    public static <T> List<List<T>> getPermutations(List<T> elements) {
        return getPermutations(elements, elements.size());
    }

    public static <T> List<List<T>> getPermutations(List<T> elements, int length) {
        return getPermutations(elements, new ArrayList<>(), length);
    }

    private static <T> List<List<T>> getPermutations(List<T> remaining, List<T> soFar, int length) {
        if (soFar.size() == length) {
            List<List<T>> permutations = new ArrayList<>();
            permutations.add(soFar);
            return permutations;
        }
        if (remaining.isEmpty()) {
            throw new IllegalArgumentException("Not enough elements for the given length!");
        }
        List<List<T>> permutations = new ArrayList<>();
        for (T element : remaining) {
            List<T> nextSoFar = new ArrayList<>(soFar);
            nextSoFar.add(element);
            List<T> nextRemaining = new ArrayList<>(remaining);
            nextRemaining.remove(element);
            permutations.addAll(getPermutations(nextRemaining, nextSoFar, length));
        }
        return permutations;
    }

    public static <T> List<List<T>> getCombinations(List<T> elements) {
        return getCombinations(elements, elements.size());
    }

    public static <T> List<List<T>> getCombinations(List<T> elements, int length) {
        return getCombinations(elements, new ArrayList<>(), length);
    }

    private static <T> List<List<T>> getCombinations(List<T> elements, List<T> soFar, int length) {
        if (soFar.size() == length) {
            List<List<T>> combinations = new ArrayList<>();
            combinations.add(soFar);
            return combinations;
        }
        List<List<T>> combinations = new ArrayList<>();
        for (T element : elements) {
            List<T> nextSoFar = new ArrayList<>(soFar);
            nextSoFar.add(element);
            combinations.addAll(getCombinations(elements, nextSoFar, length));
        }
        return combinations;
    }
}
