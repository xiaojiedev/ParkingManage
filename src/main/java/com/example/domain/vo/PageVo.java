package com.example.domain.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Data
public class PageVo {
    private Integer pageNum;
    private Integer pageSize;
}
