package com.lsk.freechat.backend.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Group and user binding table
 */
@Data
@TableName("group_user")
@NoArgsConstructor
@AllArgsConstructor
public class GroupUser {

    /**
     * Record ID
     */
    @TableField("id")
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * User id
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * Group ID
     */
    @TableField("group_id")
    private Integer groupId;

    /**
     * User's role in the group
     * Can be OWNER, ADMIN, MEMBER
     */
    @TableField("user_role")
    private String userRole;

    /**
     * User nickname in the group
     */
    @TableField("nickname")
    private String nickname;

}
