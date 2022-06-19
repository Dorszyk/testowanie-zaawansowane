package com.sda.testing.solution.mockito.argument.matchers;

public interface MessageValidator {

    boolean isMessageRecipentReachable(final String recipentId);
    boolean isMessageValid(Message message);
}