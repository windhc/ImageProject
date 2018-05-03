package com.windhc.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

/**
 * 图册标签
 * @author Administrator
 * @date 2015/8/26
 */
@Table(name = "tb_tag")
@JsonIgnoreProperties(value={"atlases"})
public class Tag {

    @Id
    @GeneratedValue
    private Long id;

    private String tagName;

    private Long pictypeId;

    private PicType picType;

    private List<Atlas> atlases;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Long getPictypeId() {
        return pictypeId;
    }

    public void setPictypeId(Long pictypeId) {
        this.pictypeId = pictypeId;
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
