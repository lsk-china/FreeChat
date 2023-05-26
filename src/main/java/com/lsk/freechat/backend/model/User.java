package com.lsk.freechat.backend.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User Structure
 */
@Data
@TableName("user")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    /**
     * User ID
     */
    @TableId(type = IdType.AUTO)
    @TableField("id")
    private Long id;

    /**
     * User name
     */
    @TableField("username")
    private String username;

    /**
     * Password, sha256 encoded
     */
    @TableField("password")
    private String password;

    /**
     * User email
     */
    @TableField("email")
    private String email;

    /**
     * Image ID for avatar, default = 0 (Image for a default avatar)
     */
    @TableField("avatar")
    private Long avatar;
}
