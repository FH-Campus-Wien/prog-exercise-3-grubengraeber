package at.ac.fhcampuswien.guessingGame.controller;

import at.ac.fhcampuswien.util.InputValidator;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class GameController {

    private final InputValidator inputValidator;
    private final int NUMBER_TO_GUESS;

    public boolean isAnswerFound(int answer) {
        return answer == NUMBER_TO_GUESS;
    }

    public boolean isNumberToGuessBigger(int answer) {
        return NUMBER_TO_GUESS > answer;
    }

    public Optional<Integer> handleInputString(String stringAnswer) {
        return inputValidator.IsNumber(stringAnswer) ? Optional.of(Integer.parseInt(stringAnswer)) : Optional.empty();
    }
}
