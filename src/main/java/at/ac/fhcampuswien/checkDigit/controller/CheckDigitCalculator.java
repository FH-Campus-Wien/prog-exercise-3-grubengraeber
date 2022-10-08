package at.ac.fhcampuswien.checkDigit.controller;

import java.util.stream.IntStream;

public class CheckDigitCalculator {
    private final int NUMBER_TO_INCREMENT_THE_INDEX_WITH = 2;
    private final int MODULO_NUMBER = 11;
    private final int NUMBER_TO_SUBTRACT_FROM = 11;
    private final int CORNER_CASE_NUMBER_ONE = 5;
    private final int CORNER_CASE_NUMBER_TWO = 0;
    private final int EXCEPTION_ONE = 11;
    private final int EXCEPTION_TWO = 10;

    public int calculateCheckDigit(int[] numbers) {
        int calculationResult = NUMBER_TO_SUBTRACT_FROM - (getCalculatedResult(numbers) % MODULO_NUMBER);
        int result = calculationResult != EXCEPTION_ONE ? calculationResult : CORNER_CASE_NUMBER_ONE;
        return result == EXCEPTION_TWO ? CORNER_CASE_NUMBER_TWO : result;
    }

    private int getCalculatedResult(int[] numbers) {
        return IntStream.range(0, numbers.length)
                .map(index -> (numbers[index] * (index + NUMBER_TO_INCREMENT_THE_INDEX_WITH)))
                .sum();
    }
}
