package com.example.challenge4.service;

public class NullRequestException extends RuntimeException {
    public NullRequestException(String message) {
        super(message);
    }
}
