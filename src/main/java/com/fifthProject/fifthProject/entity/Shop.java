package com.fifthProject.fifthProject.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class Shop {

    private Long id;
    private String name;
    private String Address;
    private OffsetDateTime createTime;
    private Long sellerId;
}
