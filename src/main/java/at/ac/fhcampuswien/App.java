package at.ac.fhcampuswien;

import at.ac.fhcampuswien.calendar.controller.CalendarController;
import at.ac.fhcampuswien.calendar.view.CalendarDisplay;
import at.ac.fhcampuswien.guessingGame.controller.GameController;
import at.ac.fhcampuswien.guessingGame.view.GameView;
import at.ac.fhcampuswien.randomNumbers.controller.RandomNumberController;
import at.ac.fhcampuswien.util.InputValidator;

import java.util.Arrays;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;

public class App {

    // Implement all methods as public static

    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    private static final InputValidator inputValidator = new InputValidator();

    private static final int NUMBER_OF_ROUNDS = 10;
    private static final int SMALLEST_RANDOM_NUMBER = 1;
    private static final int BIGGEST_RANDOM_NUMBER = 101;

    public static void main(String[] args) {
        oneMonthCalendar(28, 1);
        System.out.println(Arrays.toString(lcg(0)));
        guessingGame(19);
    }

    public static void oneMonthCalendar(int dayCountThisMonth, int startingDayIndex) {
        CalendarController calendarController = new CalendarController();
        CalendarDisplay calendarDisplay = new CalendarDisplay(scanner);

        String calendar = calendarController.calculateCalendarString(dayCountThisMonth, startingDayIndex);
        calendarDisplay.printCalendar(calendar);
    }

    public static long[] lcg(long seed) {
        RandomNumberController randomNumberController = new RandomNumberController();
        long[] tenPseudoRandomNumbers = randomNumberController.getRandomNumbers(seed);
        return tenPseudoRandomNumbers;
    }

    public static void guessingGame(int numberToGuess) {
        GameController gameController = new GameController(inputValidator, numberToGuess);
        // INTERESTING SITUATION WITH THE SCANNER OBJECT
        // I GET AN INVOCATION_TARGET_EXCEPTION FOR USING THE SAME SCANNER, THAT IS INJECTED INTO EVERY METHOD "scanner"
        // IN THE "guessingGame1" TEST, NO EXCEPTION IS THROWN, BUT IN THE SECOND TEST "guessingGame2", THE ->
        // INVOCATION_TARGET_EXCEPTION IS THROWN
        // BY INJECTING A NEW SCANNER OBJECT THIS EXCEPTION DOESN'T OCCUR
        // SINCE THERE IS NO WAY OF FLUSHING A SCANNER OBJECT OR EMPTYING THE BUFFER OF THE SCANNER OBJECT ->
        // THIS SOLUTION IS THE ONLY WAY I WAS ABLE TO FIX IT
        GameView gameView = new GameView(new Scanner(System.in));

        boolean foundTheAnswer;
        for (int round = 1; round < (NUMBER_OF_ROUNDS + 1); round++) {
            String stringAnswer = gameView.askForAnswer(round);
            Optional<Integer> optionalAnswer = gameController.handleInputString(stringAnswer);
            int answer;
            if (optionalAnswer.isPresent()) {
                answer = optionalAnswer.get();
            } else {
                return;
            }
            foundTheAnswer = gameController.isAnswerFound(answer);
            if (foundTheAnswer) {
                gameView.saySuccessMessage();
                return;
            }
            boolean numberToGuessIsBigger = gameController.isNumberToGuessBigger(answer);
            if (round < NUMBER_OF_ROUNDS) {
                gameView.giveTip(numberToGuessIsBigger);
                continue;
            }
            break;
        }
        gameView.sayLosingMessage();
    }

    public static int randomNumberBetweenOneAndHundred() {
        return random.nextInt(SMALLEST_RANDOM_NUMBER, BIGGEST_RANDOM_NUMBER);
    }
}