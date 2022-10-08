package at.ac.fhcampuswien.util;

public class InputValidator {

    public boolean IsNumber(String input) {
        boolean result = false;
        try {
            Integer.parseInt(input);
            result = true;
        } catch (Exception exception) {
            System.out.println(input + " is not a number: " + exception);
        }
        return result;
    }
}
