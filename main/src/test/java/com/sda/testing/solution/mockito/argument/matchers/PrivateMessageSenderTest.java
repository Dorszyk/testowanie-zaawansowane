package com.sda.testing.solution.mockito.argument.matchers;

import com.sda.testing.solution.mockito.databasestore.SdaException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PrivateMessageSenderTest {
    private static final String TEXT = "Hi Andrzej";
    private static final String AUTHOR_ID = "Andrzej";
    private static final String RECIPENT_ID = "Ala";

    @Mock
    private MessageSender messageSender;

    @Mock
    private MessageValidator messageValidator;

    @InjectMocks
    private PrivateMessageSender privateMessageSender;

    @Test
    void shouldSendPrivateMessage() {
        when(messageValidator.isMessageValid(any())).thenReturn(true);
        when(messageValidator.isMessageRecipentReachable(anyString())).thenReturn(true);
        doNothing().when(messageSender).send(any(Message.class), eq(MessageType.PRIVATE));

        privateMessageSender.sendPrivateMessage(TEXT, AUTHOR_ID, RECIPENT_ID);

        final InOrder inOrder = Mockito.inOrder(messageValidator);
        inOrder.verify(messageValidator).isMessageValid(any());
        inOrder.verify(messageValidator).isMessageRecipentReachable(anyString());
    }

    @Test
    void shouldThrowWhenRecipentIsInvalid() {
        when(messageValidator.isMessageValid(any())).thenReturn(true);
        when(messageValidator.isMessageRecipentReachable(anyString())).thenReturn(false);

        assertThatExceptionOfType(SdaException.class)
                .isThrownBy(() -> privateMessageSender.sendPrivateMessage(TEXT, AUTHOR_ID, RECIPENT_ID))
                .withNoCause();

        final InOrder inOrder = Mockito.inOrder(messageValidator);
        inOrder.verify(messageValidator).isMessageValid(any());
        inOrder.verify(messageValidator).isMessageRecipentReachable(anyString());
    }
}