package com.hc.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

/**
 * 图册标签
 * Created by Administrator on 2015/8/26.
 */
@Entity
@Table(name = "tb_tag")
@JsonIgnoreProperties(value={"atlases"})
public class Tag {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String tag;

    @ManyToOne
    @JoinColumn(name = "pictype_id")
    private PicType picType;

    @ManyToMany(fetch = FetchType.LAZY,mappedBy="tags") //mappedBy 由Atlas中的tags来维护级联关系
    private List<Atlas> atlases;

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

    public List<Atlas> getAtlases() {
        return atlases;
    }

    public void setAtlases(List<Atlas> atlases) {
        this.atlases = atlases;
    }
}
