package com.hc.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 图片类型
 * Created by Administrator on 2015/8/26.
 */
@Entity
@Table(name = "tb_pictype")
public class PicType {
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String pictype;

    @OneToMany(mappedBy="picType") //mappedBy 由Tag中的picType来维护级联关系
    private List<Tag> tags = new ArrayList<Tag>();

    @OneToMany(mappedBy="picType") //mappedBy 由Atlas中的picType来维护级联关系
    private List<Atlas> atlases = new ArrayList<Atlas>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPictype() {
        return pictype;
    }

    public void setPictype(String pictype) {
        this.pictype = pictype;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<Atlas> getAtlases() {
        return atlases;
    }

    public void setAtlases(List<Atlas> atlases) {
        this.atlases = atlases;
    }
}
