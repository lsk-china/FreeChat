package com.lsk.freechat.backend.ws.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import reactor.util.annotation.Nullable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    private String type;

    @Nullable
    private Integer atUserId;

    @Nullable
    private Integer replies;

    private String content;

}
