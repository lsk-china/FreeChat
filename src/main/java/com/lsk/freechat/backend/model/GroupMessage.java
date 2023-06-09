package com.lsk.freechat.backend.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Group and message binding table
 */
@Data
@TableName("group_message")
@NoArgsConstructor
@AllArgsConstructor
public class GroupMessage {

    /**
     * Record ID
     */
    @TableField("id")
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * Chat ID
     */
    @TableField("group_id")
    private Long groupId;

    /**
     * Message ID
     */
    @TableField("message_id")
    private Long messageId;
}
