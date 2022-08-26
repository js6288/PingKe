package com.ljs.pingke.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName rollad
 */
@TableName(value ="rollad")
@Data
public class Rollad implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer imgId;

    /**
     * 
     */
    private String imgSrc;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}