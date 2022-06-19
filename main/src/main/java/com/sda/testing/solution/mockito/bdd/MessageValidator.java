package com.sda.testing.solution.mockito.bdd;

public interface MessageValidator {

    boolean isMessageRecipentReachable(final String recipentId);
    boolean isMessageValid(Message message);
}