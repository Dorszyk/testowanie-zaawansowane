package com.sda.testing.solution.mockito.bdd;


public interface MessageSender {
    void send(Message message, MessageType messageType);
}
