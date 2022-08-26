package com.ljs.pingke.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 *
 * @TableName item
 */
@TableName(value ="item")
@Data
public class Item implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Integer itemId;

    /**
     *
     */
    private Integer userId;

    /**
     *
     */
    private Date createTime;

    /**
     *
     */
    private Date endTime;

    /**
     *
     */
    private Date finishedTime;

    /**
     *
     */
    private String itemType;

    /**
     *
     */
    private String requirement;

    /**
     *
     */
    private String refuseMessage;

    /**
     *
     */
    private String contactName;

    /**
     *
     */
    private String contactNumber;

    /**
     *
     */
    private Integer adminId;

    /**
     * item_status
     * --------------
     * toBeSolved            用户提交后的默认状态，等待管理员处理
     * toBeFinished         管理员接受了，正在制作
     * refused                  管理员拒绝了，拒绝理由显示在refuse_message中
     * finished                 管理员已经完成了作品，地址在download_address
     */
    private String itemStatus;

    /**
     *
     */
    private String uploadAddress;

    /**
     *
     */
    private String downloadAddress;

    /**
     *
     */
    private String itemName;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
