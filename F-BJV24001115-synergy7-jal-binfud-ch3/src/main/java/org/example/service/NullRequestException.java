package org.example.service;

public class NullRequestException extends RuntimeException{
    public NullRequestException(String message) {
        super(message);
    }

}
