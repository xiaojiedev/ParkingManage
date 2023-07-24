package com.example.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;


@Data
@TableName(value = "t_admin")
public class TAdmin {
    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    @TableField(value = "admin_num")
    private String adminNum;

    /**
     * 密码
     */
    @TableField(value = "admin_name")
    private String adminName;

    /**
     * 默认  0 未删除 1删除
     */
    @TableField(value = "admin_tel")
    private Integer adminTel;

    /**
     * 0 启用 1 禁用
     */
    @TableField(value = "admin_post")
    private Integer adminPost;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private Date updateTime;

    @TableField(value = "park_id")
    private Integer parkId;

    @TableLogic
    @TableField(value = "deleted")
    private Integer deleted;

    public static final String COL_ID = "id";

    public static final String COL_ADMIN_NUM = "admin_num";

    public static final String COL_ADMIN_NAME = "admin_name";

    public static final String COL_ADMIN_TEL = "admin_tel";

    public static final String COL_ADMIN_POST = "admin_post";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";

    public static final String COL_PARK_ID = "park_id";

    public static final String COL_DELETED = "deleted";

}
