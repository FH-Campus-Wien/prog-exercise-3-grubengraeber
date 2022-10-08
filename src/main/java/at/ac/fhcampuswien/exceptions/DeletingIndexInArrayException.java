package at.ac.fhcampuswien.exceptions;

import lombok.ToString;

@ToString
public class DeletingIndexInArrayException extends ArrayIndexOutOfBoundsException {
    String message;

    public DeletingIndexInArrayException(String message) {
        this.message = message;
    }

}
