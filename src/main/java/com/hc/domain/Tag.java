package com.hc.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 图册标签
 * Created by Administrator on 2015/8/26.
 */
@Entity
@Table(name = "tb_tag")
public class Tag {
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String tag;

    @ManyToOne
    @JoinColumn(name = "pictype_id")
    private PicType picType;

    @OneToMany(mappedBy="tag") //mappedBy 由Atlas中的tag来维护级联关系
    private List<Atlas> atlases = new ArrayList<Atlas>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public PicType getPicType() {
        return picType;
    }

    public void setPicType(PicType picType) {
        this.picType = picType;
    }

    public List<Atlas> getAtlases() {
        return atlases;
    }

    public void setAtlases(List<Atlas> atlases) {
        this.atlases = atlases;
    }
}
