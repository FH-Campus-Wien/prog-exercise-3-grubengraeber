package at.ac.fhcampuswien.guessingGame.view;

import lombok.RequiredArgsConstructor;

import java.util.Scanner;

@RequiredArgsConstructor
public class GameView {
    private final Scanner scanner;

    public String askForAnswer(int round) {
        sayGuessNumber(round);
        String answer = scanner.next();
        return answer;
    }

    private void sayGuessNumber(int round) {
        System.out.print("Guess number " + round + ": ");
    }

    public void saySuccessMessage() {
        System.out.print("You won wisenheimer!" + System.lineSeparator());
    }

    public void giveTip(boolean numberToGuessIsBigger) {
        String result = "The number AI picked is ";
        result += numberToGuessIsBigger ? "higher" : "lower";
        result += " than your guess.";
        System.out.print(result + System.lineSeparator());
    }

    public void sayLosingMessage() {
        System.out.print("You lost! Have you ever heard of divide & conquer?" + System.lineSeparator());
    }
}
