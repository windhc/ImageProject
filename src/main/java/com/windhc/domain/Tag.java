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
    @GeneratedValue(generator = "JDBC")
    private Long id;

    private String tagName;

    private Long pictureTypeId;

    private PictureType pictureType;

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

    public List<Atlas> getAtlases() {
        return atlases;
    }

    public void setAtlases(List<Atlas> atlases) {
        this.atlases = atlases;
    }
}
