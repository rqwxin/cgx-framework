package com.framework.manger.controller;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
public class HelloVO implements Serializable {
    private String name;

    private String context;

    private Date createTime;
}
