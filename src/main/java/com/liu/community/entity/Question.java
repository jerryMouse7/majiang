package com.liu.community.entity;

import lombok.Data;

@Data
public class Question {
    private int id;

    private String title;

    private String creator;

    private String description;

    private int commentCount;

    private int viewCount;

    private int likeCount;

    private String tag;

    private String gmtCreate;

    private String gmtModified;
}







