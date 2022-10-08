package at.ac.fhcampuswien.util;

public class AsciiConverter {
    private final int NUMBER_BETWEEN_UPPER_AND_LOWER_CASE_LETTERS = 32;
    private final int NUMBER_OF_LAST_UPPER_CASE_LETTER = 90;

    public char convertIntoOtherCase(char characterToConvert) {
        return (char) (characterToConvert > NUMBER_OF_LAST_UPPER_CASE_LETTER
                ? characterToConvert - NUMBER_BETWEEN_UPPER_AND_LOWER_CASE_LETTERS
                : characterToConvert + NUMBER_BETWEEN_UPPER_AND_LOWER_CASE_LETTERS);
    }
}
