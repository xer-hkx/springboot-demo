package com.resource.share.entity;

import java.util.Date;

public class Resource {
    private Integer id;
    private String name;
    private String description;
    private Date publishTime;
    private Integer userId;
    private Integer download;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getDownload() {
        return download;
    }

    public void setDownload(Integer download) {
        this.download = download;
    }
}
