package org.example.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NullRequestExceptionTest {
    @Test
    public void NullRequestExceptionTest(){
        String expectedMessage = "Minimal 1 jumlah pesanan";
        NullRequestException actualMessage = new NullRequestException(expectedMessage);

        Assertions.assertEquals(expectedMessage, actualMessage.getMessage());
    }

}