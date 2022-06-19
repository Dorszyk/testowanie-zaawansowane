package com.sda.testing.solution.mockito.bdd;

import com.sda.testing.solution.mockito.databasestore.SdaException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.*;


import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
class PrivateMessageSenderTestBdd {

    private static final String TEXT = "Hi Andrzej";
    private static final String AUTHOR_ID = "Andrzej";
    private static final String RECIPENT_ID = "Ala";

    @Mock
    private MessageSender messageSender;

    @Mock
    private MessageValidator messageValidator;

    @InjectMocks
    private PrivateMessageSender privateMessageSender;

    @Captor
    private ArgumentCaptor<Message> messageCaptor;

    @Test
    void shouldSendPrivateMessage() {
        given(messageValidator.isMessageValid(any())).willReturn(true);
        given(messageValidator.isMessageRecipentReachable(anyString())).willReturn(true);
        BDDMockito.doNothing().when(messageSender).send(any(Message.class), eq(MessageType.PRIVATE));

        privateMessageSender.sendPrivateMessage(TEXT, AUTHOR_ID, RECIPENT_ID);

        then(messageValidator).should().isMessageValid(messageCaptor.capture());
        then(messageSender).should().send(messageCaptor.capture(), eq(MessageType.PRIVATE));
        final List<Message> allCapturedValues = messageCaptor.getAllValues();
        assertThat(new HashSet<>(allCapturedValues)).hasSize(1);
        assertMessageContainsExpectedFields(allCapturedValues.get(0));
    }

    private void assertMessageContainsExpectedFields(final Message message) {
        assertThat(message.getAuthor()).isEqualTo(AUTHOR_ID);
        assertThat(message.getRecipent()).isEqualTo(RECIPENT_ID);
        assertThat(message.getValue()).isEqualTo(TEXT);
        assertThat(message.getSendAt()).isNotNull();
        assertThat(message.getId()).isNotNull();
    }

    @Test
    void shouldThrowWhenRecipentIsInvalid() {
        given(messageValidator.isMessageValid(any())).willReturn(true);
        given(messageValidator.isMessageRecipentReachable(anyString())).willReturn(false);

        assertThatExceptionOfType(SdaException.class)
                .isThrownBy(() -> privateMessageSender.sendPrivateMessage(TEXT, AUTHOR_ID, RECIPENT_ID))
                .withNoCause();

        then(messageValidator).should().isMessageValid(messageCaptor.capture());
        assertMessageContainsExpectedFields(messageCaptor.getValue());
    }
}