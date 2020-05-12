package com.cs.exception;

/**
 * This exception is thrown when command is not valid or canvas is not created.
 *
 * @author anuja
 */
public class DrawingException extends RuntimeException {
    public DrawingException(String message) {
        super(message);
    }
}
