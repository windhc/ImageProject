package com.hc.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

/**
 * 图册
 * Created by Administrator on 2015/8/26.
 */
@Entity
@Table(name = "tb_atlas")
@JsonIgnoreProperties(value={"pictures"})
public class Atlas {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String atlas;

    @Column(nullable = false)
    private String addtime;

    @ManyToMany
    private List<Tag> tags;

    @ManyToOne
    @JoinColumn(name = "pictype_id")
    private PicType picType;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "atlas")
    private List<Picture> pictures;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

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

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }

    public PicType getPicType() {
        return picType;
    }

    public void setPicType(PicType picType) {
        this.picType = picType;
    }

    public List<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }
}
