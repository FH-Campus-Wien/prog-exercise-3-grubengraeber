package at.ac.fhcampuswien.camelCase.controller;

import at.ac.fhcampuswien.util.AsciiConverter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CamelCaseConverter {

    private final AsciiConverter asciiConverter;

    private final int BEGIN_OF_UPPERCASE_LETTERS = 65;
    private final int END_OF_UPPERCASE_LETTERS = 90;
    private final int BEGIN_OF_LOWERCASE_LETTERS = 97;
    private final int END_OF_LOWERCASE_LETTERS = 122;
    private final int EXPRESSION_MARK = 33;
    private final int QUOTE = 39;
    private final int COMMA = 44;
    private final int COLON = 46;
    private final int QUESTION_MARK = 63;

    public String formatText(String textToFormat) {
        System.out.println("textToFormat = " + textToFormat);
        char[] characters = textToFormat.toCharArray();
        // Make every word upper case
        toUppercase(characters);
        // Make every word camel case
        characters = toCamelCase(characters);
        //return String value of char array
        return new String(characters);
    }

    private char[] toCamelCase(char[] characters) {
        int letterCount = countLetters(characters);
        char[] camelCaseCharacters = new char[letterCount];
        int newArrayIndex = 0;
        for (int index = 0; index < characters.length - 1; index++) {
            char character = characters[index];
            if (isLetter(character) && index != 0
                    && lastCharacterWasNotWhitespace(index, characters)) {
                camelCaseCharacters[newArrayIndex] = asciiConverter.convertIntoOtherCase(character);
                newArrayIndex++;
            } else if (isLetter(character)) {
                camelCaseCharacters[newArrayIndex] = character;
                newArrayIndex++;
            }
        }
        return camelCaseCharacters;
    }

    private boolean lastCharacterWasNotWhitespace(int index, char[] characters) {
        int lastIndex = index - 1;
        return isLetter(characters[lastIndex]) || lastCharacterWasSentenceSign(index, characters);
    }

    private boolean lastCharacterWasSentenceSign(int thisIndex, char[] characters) {
        for (int index = 0; index < characters.length; index++) {
            char character = characters[index];
            int lastIndex = thisIndex - 1;
            if (index == lastIndex &&
                    (character == COLON || character == EXPRESSION_MARK || character == QUOTE ||
                            character == COMMA || character == QUESTION_MARK)) {
                return true;
            }
        }
        return false;
    }

    private int countLetters(char[] characters) {
        int counter = 0;
        for (char character : characters) {
            if (isLetter(character)) {
                counter++;
            }
        }
        return counter;
    }

    private boolean isLetter(char character) {
        return character >= BEGIN_OF_UPPERCASE_LETTERS && character <= END_OF_UPPERCASE_LETTERS || character >= BEGIN_OF_LOWERCASE_LETTERS && character <= END_OF_LOWERCASE_LETTERS;
    }


    private void toUppercase(char[] characters) {
        for (int index = 0; index < characters.length; index++) {
            char character = characters[index];
            if (character >= BEGIN_OF_LOWERCASE_LETTERS && character <= END_OF_LOWERCASE_LETTERS) {
                char upperCaseCharacter = asciiConverter.convertIntoOtherCase(character);
                characters[index] = upperCaseCharacter;
            }
        }
    }
}
