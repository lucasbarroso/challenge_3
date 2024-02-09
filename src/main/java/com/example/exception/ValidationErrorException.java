package com.example.exception;

/**
 * Exceção lançada quando ocorre uma validação de erro.
 */

public class ValidationErrorException extends RuntimeException {
    public ValidationErrorException(String msg) {
        super(msg);
    }
}
