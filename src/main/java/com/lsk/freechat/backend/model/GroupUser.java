package com.lsk.freechat.backend.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName("group_user")
@NoArgsConstructor
@AllArgsConstructor
public class GroupUser {

    @TableField("id")
    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField("user_id")
    private Integer userId;

    @TableField("group_id")
    private Integer groupId;

    @TableField("user_role")
    private String userRole;

    @TableField("nickname")
    private String nickname;

}
