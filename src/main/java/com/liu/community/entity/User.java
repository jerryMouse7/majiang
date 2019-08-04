package com.liu.community.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class User {
    private int id;
    private String accountId;
    private String name;
    private String password;
    private String token;
    private String gmtCreate;
    private String gmtModified;


}
