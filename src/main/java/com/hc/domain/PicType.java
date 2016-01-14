package com.hc.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

/**
 * 图片类型
 * Created by Administrator on 2015/8/26.
 */
@Entity
@Table(name = "tb_pictype")
@JsonIgnoreProperties(value = {"tags"})
public class PicType {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String typeName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "picType") //mappedBy 由Tag中的picType来维护级联关系
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
