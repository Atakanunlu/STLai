package com.atakanunlu.STLai.entity;

import com.atakanunlu.STLai.enums.MessageRole;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChatMessage {

    Long id;
    ChatSession chatSession;

    String content;

    MessageRole role;

    String toolCalls; //cağrılan aracların JSON dizisi

    Integer tokenUsed;

    Instant createdAt;


}
