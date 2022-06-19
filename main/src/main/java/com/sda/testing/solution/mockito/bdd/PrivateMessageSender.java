package com.sda.testing.solution.mockito.bdd;

import com.sda.testing.solution.mockito.databasestore.SdaException;

import java.time.LocalDateTime;
import java.util.UUID;

public class PrivateMessageSender {
    private final MessageSender messageSender;
    private final MessageValidator messageValidator;

    public PrivateMessageSender(final MessageSender messageSender, final MessageValidator messageValidator) {
        this.messageSender = messageSender;
        this.messageValidator = messageValidator;
    }

    public void sendPrivateMessage(final String text, final String authorId, final String recipentId) {
        final Message message = new Message(UUID.randomUUID(), text, LocalDateTime.now(), authorId, recipentId);
        if (!messageValidator.isMessageValid(message) || !messageValidator.isMessageRecipentReachable(recipentId)) {
            throw new SdaException("Cannot send private message. Validation failed");
        }
        messageSender.send(message, MessageType.PRIVATE);
    }
}
