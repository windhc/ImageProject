package com.hc.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 图册
 * Created by Administrator on 2015/8/26.
 */
@Entity
@Table(name = "tb_atlas")
public class Atlas {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String atlas;

    @Column(nullable = false)
    private String addtime;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Tag tag;

    @ManyToOne
    @JoinColumn(name = "pictype_id")
    private PicType picType;

    @OneToMany(mappedBy="atlas") //mappedBy 由Picture中的atlas来维护级联关系
    private List<Picture> pictures = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public PicType getPicType() {
        return picType;
    }

    public void setPicType(PicType picType) {
        this.picType = picType;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }

    public List<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }
}
