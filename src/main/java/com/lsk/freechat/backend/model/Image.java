package com.lsk.freechat.backend.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Image Structure
 */
@Data
@TableName("image")
@NoArgsConstructor
@AllArgsConstructor
public class Image {

    /**
     * Image ID
     */
    @TableField("id")
    @TableId(type= IdType.AUTO)
    private Long id;

    /**
     * Image url
     */
    @TableField("url")
    private String url;

    /**
     * Should keep this image forever (1 = true, default 0)
     */
    @TableField("keep_forever")
    private Integer keepForever;
}
