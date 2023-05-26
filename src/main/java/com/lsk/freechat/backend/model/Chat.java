package com.lsk.freechat.backend.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Chat Structure
 */
@Data
@TableName("chat")
@NoArgsConstructor
@AllArgsConstructor
public class Chat {

    /**
     * Chat ID
     */
    @TableField("id")
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * Chat name
     */
    @TableField("name")
    private String name;

    /**
     * One user ID of this chat
     */
    @TableField("user1")
    private Long user1;

    /**
     * The other user ID of this chat
     */
    @TableField("user2")
    private Long user2;

    /**
     * Create time of the chat
     */
    @TableField("create_time")
    private Date createTime;
}
