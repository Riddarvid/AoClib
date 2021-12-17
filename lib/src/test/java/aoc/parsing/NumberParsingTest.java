package aoc.parsing;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberParsingTest {
    @Test
    public void ParsePositiveContainingMinusSigns() {
        String input = "2hello123it3is-42-54-nice to see you5";
        List<Integer> expectedOutput = new ArrayList<>();
        expectedOutput.add(2);
        expectedOutput.add(123);
        expectedOutput.add(3);
        expectedOutput.add(42);
        expectedOutput.add(54);
        expectedOutput.add(5);
        assertEquals(expectedOutput, ParsingUtils.getIntegers(input));
    }

    @Test
    public void ParseNegativeContainingMinusSigns() {
        String input = "2hello123it3is-42-54-nice to see you5";
        List<Integer> expectedOutput = new ArrayList<>();
        expectedOutput.add(2);
        expectedOutput.add(123);
        expectedOutput.add(3);
        expectedOutput.add(-42);
        expectedOutput.add(-54);
        expectedOutput.add(5);
        assertEquals(expectedOutput, ParsingUtils.getIntegersNegative(input));
    }
}
