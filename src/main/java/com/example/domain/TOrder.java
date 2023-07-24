package com.example.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;


@Data
@TableName(value = "t_order")
public class TOrder {
    @TableId(value = "order_id", type = IdType.INPUT)
    private Integer orderId;

    @TableField(value = "car_num")
    private Integer carNum;

    @TableField(value = "card")
    private String card;

    @TableField(value = "park_time")
    private Float parkTime;

    @TableField(value = "payment")
    private Integer payment;

    @TableField(value = "pay_way")
    private Integer payWay;

    @TableField(value = "car_statu")
    private Integer carStatu;

    @TableField(value = "admin_name")
    private String adminName;

    @TableField(value = "park_id")
    private Integer parkId;

    @TableField(value = "verification_code")
    private Integer verificationCode;

    @TableLogic
    @TableField(value = "deleted")
    private Integer deleted;

    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    public static final String COL_ORDER_ID = "order_id";

    public static final String COL_CAR_NUM = "car_num";

    public static final String COL_CARD = "card";

    public static final String COL_PARK_TIME = "park_time";

    public static final String COL_PAYMENT = "payment";

    public static final String COL_PAY_WAY = "pay_way";

    public static final String COL_CAR_STATU = "car_statu";

    public static final String COL_ADMIN_NAME = "admin_name";

    public static final String COL_PARK_ID = "park_id";

    public static final String COL_VERIFICATION_CODE = "verification_code";

    public static final String COL_DELETED = "deleted";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";

}
