package com.ljs.pingke.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName admin
 */
@TableName(value ="admin")
@Data
public class Admin implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer adminId;

    /**
     * 
     */
    private String adminName;

    /**
     * 
     */
    private String password;

    /**
     * 
     */
    private String realName;

    /**
     * 
     */
    private String contactNumber;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}