package codewiththugboy.tourist.exceptions;

import org.springframework.http.HttpStatus;

public class DuplicateEmailException extends TouristExceptions {
    public DuplicateEmailException(String message, HttpStatus status) {
        super(message);
        this.getStatusCode();
    }
}
