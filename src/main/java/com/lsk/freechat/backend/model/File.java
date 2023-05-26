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
 * File Structure
 */
@Data
@TableName("file")
@NoArgsConstructor
@AllArgsConstructor
public class File {

    /**
     * File ID
     */
    @TableField("id")
    @TableId(type= IdType.AUTO)
    private Long id;

    /**
     * File path
     * The url to the file
     */
    @TableField("path")
    private String path;

    /**
     * File name
     */
    @TableField("name")
    private String name;

    /**
     * Upload user ID
     */
    @TableField("uploader")
    private Long uploader;

    /**
     * Upload date
     */
    @TableField("upload_date")
    private Date uploadDate;

}
