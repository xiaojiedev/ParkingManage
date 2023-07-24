package com.example.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.ToString;

import java.util.Date;


@Data
@ToString
@TableName(value = "t_park")
public class TPark {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 名称
     */
    @TableField(value = "park_name")
    private String parkName;

    /**
     * 地址
     */
    @TableField(value = "park_address")
    private String parkAddress;

    /**
     * 状态 0 正常 1 停止
     */
    @TableField(value = "park_status")
    private Integer parkStatus;

    /**
     * 首免时间
     */
    @TableField(value = "free_time")
    private String freeTime;

    /**
     * 阶级时间
     */
    @TableField(value = "class_time")
    private String classTime;

    /**
     * 封顶金额
     */
    @TableField(value = "max_money")
    private Double maxMoney;

    /**
     * 支付方式
     */
    @TableField(value = "play_method")
    private String playMethod;

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

    /**
     * 0 未删除 1 删除
     */
    @TableLogic
    @TableField(value = "deleted")
    private Integer deleted;

    /**
     * 联系人
     */
    @TableField(value = "park_people")
    private String parkPeople;

    @TableField(value = "class_money")
    private String classMoney;

    /**
     * 类型
     */
    @TableField(value = "park_type")
    private String parkType;

    @TableField(value = "people_phone")
    private String peoplePhone;

    @TableField(value = "park_other")
    private String parkOther;

    public static final String COL_ID = "id";

    public static final String COL_PARK_NAME = "park_name";

    public static final String COL_PARK_ADDRESS = "park_address";

    public static final String COL_PARK_STATUS = "park_status";

    public static final String COL_FREE_TIME = "free_time";

    public static final String COL_CLASS_TIME = "class_time";

    public static final String COL_MAX_MONEY = "max_money";

    public static final String COL_PLAY_METHOD = "play_method";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";

    public static final String COL_DELETED = "deleted";

    public static final String COL_PARK_PEOPLE = "park_people";

    public static final String COL_CLASS_MONEY = "class_money";

    public static final String COL_PARK_TYPE = "park_type";

    public static final String COL_PEOPLE_PHONE = "people_phone";

    public static final String COL_PARK_OTHER = "park_other";

}
