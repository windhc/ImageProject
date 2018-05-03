package com.windhc.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

/**
 * 图片类型
 *
 * @author Administrator
 * @date 2015/8/26
 */
@Table(name = "tb_picture_type")
@JsonIgnoreProperties(value = {"tags"})
public class PictureType {

    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    private String typeName;

    private List<Tag> tags;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

//    public Set<Tag> getTags() {
//        return tags;
//    }
//
//    public void setTags(Set<Tag> tags) {
//        this.tags = tags;
//    }
}
