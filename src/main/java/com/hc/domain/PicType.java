package com.hc.domain;

import javax.persistence.*;

/**
 * 图片类型
 * Created by Administrator on 2015/8/26.
 */
@Entity
@Table(name = "tb_pictype")
public class PicType {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String pictype;

//    @OneToMany(fetch = FetchType.LAZY,mappedBy="picType") //mappedBy 由Tag中的picType来维护级联关系
//    private Set<Tag> tags;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPictype() {
        return pictype;
    }

    public void setPictype(String pictype) {
        this.pictype = pictype;
    }

//    public Set<Tag> getTags() {
//        return tags;
//    }
//
//    public void setTags(Set<Tag> tags) {
//        this.tags = tags;
//    }
}
