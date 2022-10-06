package at.ac.fhcampuswien;

import at.ac.fhcampuswien.calendar.controller.CalendarController;
import at.ac.fhcampuswien.calendar.view.CalendarDisplay;
import at.ac.fhcampuswien.randomNumbers.controller.RandomNumberController;

import java.util.Arrays;
import java.util.Scanner;

public class App {

    // Implement all methods as public static

    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        oneMonthCalendar(28, 1);
        System.out.println(Arrays.toString(lcg(0)));
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
}