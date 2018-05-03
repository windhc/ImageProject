package com.windhc.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

/**
 * 图册
 *
 * @author Administrator
 * @date 2015/8/26
 */
@Table(name = "tb_atlas")
@JsonIgnoreProperties(value = {"pictures"})
public class Atlas {

    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    private String atlas;

    private String frontCover;

    private Long pictureTypeId;

    private Long userId;

    private Long createdAt;


    private List<Tag> tags;

    private User user;

    private PictureType pictureType;

    private List<Picture> pictures;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAtlas() {
        return atlas;
    }

    public void setAtlas(String atlas) {
        this.atlas = atlas;
    }

    public String getFrontCover() {
        return frontCover;
    }

    public void setFrontCover(String frontCover) {
        this.frontCover = frontCover;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public Long getPictureTypeId() {
        return pictureTypeId;
    }

    public void setPictureTypeId(Long pictureTypeId) {
        this.pictureTypeId = pictureTypeId;
    }

    public PictureType getPictureType() {
        return pictureType;
    }

    public void setPictureType(PictureType pictureType) {
        this.pictureType = pictureType;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }
}
