package com.sda.testing.solution.mockito.argument.matchers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    private UUID id;
    private String value;
    private LocalDateTime sendAt;
    private String author;
    private String recipent;
}
