package com.hc.domain;

import javax.persistence.*;

/**
 * 图册
 * Created by Administrator on 2015/8/26.
 */
@Entity
@Table(name = "tb_atlas")
public class Atlas {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String atlas;

    @Column(nullable = false)
    private String addtime;

    @ManyToOne(optional = false)
    @JoinColumn(name = "tag_id")
    private Tag tag;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy="atlas") //mappedBy 由Picture中的atlas来维护级联关系
//    private Set<Picture> pictures;

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

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }

//    public Set<Picture> getPictures() {
//        return pictures;
//    }
//
//    public void setPictures(Set<Picture> pictures) {
//        this.pictures = pictures;
//    }
}
