package at.ac.fhcampuswien.calendar.controller;

public class CalendarController {

    private final int NUMBER_OF_SIGNS_IN_ONE_CALENDAR_LINE = 21;
    public String calculateCalendarString(int dayCountThisMonth, int startingDayIndex) {
        String result = "";
        result += getWhiteSpacesAtTheBeginning(startingDayIndex);
        result += getNumbersInCalendar(result.length(), dayCountThisMonth);
        return result;
    }

    private String getNumbersInCalendar(int lengthOfStringWithWhitespaces, int dayCountOfMonth) {
        String result = "";
        int characterCounter = lengthOfStringWithWhitespaces;
        for (int day = 1; day < dayCountOfMonth + 1; day++) {
            if (day < 10) {
                result += " " + day + " ";
            } else {
                result += day + " ";
            }
            characterCounter += 3;
            if (characterCounter == NUMBER_OF_SIGNS_IN_ONE_CALENDAR_LINE && day != dayCountOfMonth) {
                result += "\n";
                characterCounter = 0;
            }
        }
        return result;
    }

    private String getWhiteSpacesAtTheBeginning(int startingIndex) {
        String result = "";
        for (int position = 1; position < startingIndex; position++) {
            result += "   ";
        }
        return result;
    }
}
