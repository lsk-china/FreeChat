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
 * User friends
 */
@Data
@TableName("friend")
@NoArgsConstructor
@AllArgsConstructor
public class Friend {

    /**
     * Record ID
     */
    @TableField("id")
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * User ID
     */
    @TableField("user_id")
    private Long userId;

    /**
     * Friend User ID
     */
    @TableField("friend_id")
    private Long friendId;

    /**
     * Time of two users become friends
     */
    @TableField("time")
    private Date time;
}
