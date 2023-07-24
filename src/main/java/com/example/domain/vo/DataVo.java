package com.example.domain.vo;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;


@Data
@ToString
@Accessors(chain = true)
public class DataVo {
    private float amount;
    private Integer orderCount;
    private Integer parkCount;
    private Integer userCount;
}
