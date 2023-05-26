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
 * Group Structure
 */
@Data
@TableName("group")
@NoArgsConstructor
@AllArgsConstructor
public class Group {

    /**
     * Group ID
     */
    @TableField("id")
    @TableId(type= IdType.AUTO)
    private Long id;

    /**
     * Group Name
     */
    @TableField("name")
    private String name;

    /**
     * Group avatar image id
     */
    @TableField("avatar")
    private Long avatar;

    /**
     * Owner User ID
     */
    @TableField("owner")
    private Long owner;

    /**
     * Create Time
     */
    @TableField("create_time")
    private Date createTime;

}
