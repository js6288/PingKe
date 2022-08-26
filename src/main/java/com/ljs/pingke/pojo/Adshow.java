package com.ljs.pingke.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName adshow
 */
@TableName(value ="adshow")
@Data
public class Adshow implements Serializable {
    /**
     * 
     */
    @TableId
    private Integer adId;

    /**
     * 
     */
    private String adName;

    /**
     * 
     */
    private String adSrc;

    /**
     * 
     */
    private String adIntroduce;

    /**
     * 
     */
    private Integer adAdminid;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}