package at.ac.fhcampuswien.calendar.view;

import lombok.RequiredArgsConstructor;

import java.util.Scanner;

@RequiredArgsConstructor
public class CalendarDisplay {
    private final Scanner scanner;

    public void printCalendar(String calendar) {
        System.out.println(calendar);
    }


}
