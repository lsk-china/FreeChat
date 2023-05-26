package com.lsk.freechat.backend.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Binding table of chat and message
 */
@Data
@TableName("chat_message")
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessage {

    /**
     * Record ID
     */
    @TableField("id")
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * Chat ID
     */
    @TableField("chat_id")
    private Long chatId;

    /**
     * Message ID
     */
    @TableField("message_id")
    private Long messageId;

}
