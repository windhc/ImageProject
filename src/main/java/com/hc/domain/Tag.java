package com.hc.domain;

import javax.persistence.*;

/**
 * 图册标签
 * Created by Administrator on 2015/8/26.
 */
@Entity
@Table(name = "tb_tag")
public class Tag {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String tag;

    @ManyToOne
    @JoinColumn(name = "pictype_id")
    private PicType picType;

//    @OneToMany(fetch = FetchType.LAZY,mappedBy="tag") //mappedBy 由Atlas中的tag来维护级联关系
//    private Set<Atlas> atlases;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

//    public Set<Atlas> getAtlases() {
//        return atlases;
//    }
//
//    public void setAtlases(Set<Atlas> atlases) {
//        this.atlases = atlases;
//    }
}
