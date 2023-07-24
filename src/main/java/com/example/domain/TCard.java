package com.example.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;


@Data
@TableName(value = "t_card")
public class TCard {
    public static final String COL_END_DATE = "end_date";
    public static final String COL_EXPRIE_DATE = "exprie_date";
    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    @TableField(value = "car_num")
    private String carNum;

    /**
     * 密码
     */
    @TableField(value = "open_date")
    private Date openDate;

    @TableField(value = "start_date")
    private Date startDate;

    /**
     * 0 启用 1 禁用
     */
    @TableField(value = "card_day")
    private Integer cardDay;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @TableField(value = "park_id")
    private Integer parkId;

    @TableField(value = "other")
    private String other;

    /**
     * 剩余时间
     */
    @TableField(value = "left_day")
    private Integer leftDay;

    /**
     * 0 正常 1 不正常
     */
    @TableField(value = "status")
    private Integer status;

    @TableLogic
    @TableField(value = "deleted")
    private Integer deleted;

    public static final String COL_ID = "id";

    public static final String COL_CAR_NUM = "car_num";

    public static final String COL_OPEN_DATE = "open_date";

    public static final String COL_START_DATE = "start_date";

    public static final String COL_CARD_DAY = "card_day";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";

    public static final String COL_PARK_ID = "park_id";

    public static final String COL_OTHER = "other";

    public static final String COL_LEFT_DAY = "left_day";

    public static final String COL_STATUS = "status";

    public static final String COL_DELETED = "deleted";

}
