package com.lsk.freechat.backend.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@TableName("message")
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    @TableField("id")
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * senderId
     * User ID of the sender
     */
    @TableField("sender_id")
    private Long senderId;

    /**
     * receiverId
     * User ID of the receiver, or Group ID of the group
     */
    @TableField("receiver_id")
    private Long receiverId;

    /**
     * sendTime
     * The time when the message is sent
     */
    @TableField("send_time")
    private Date sendTime;

    /**
     * content
     * Message content, in json format
     * {
     *     "type": "plain|image|file",
     *     "at": [user ID],
     *     "replies": [message ID],
     *     "content": A  plain text when type is "plain"
     *                An image path when type is "image"
     *                A  file  url  when type is "file"
     * }
     */
    @TableField("content")
    private String content;

    /**
     * isUndone
     * 1 when message is undone
     */
    @TableField("is_undone")
    private Integer isUndone;
}
