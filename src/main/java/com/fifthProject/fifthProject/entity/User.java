package com.fifthProject.fifthProject.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class User {

    private Long id;
    private String name;
    private OffsetDateTime createTime;

}
