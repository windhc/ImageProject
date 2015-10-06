package com.hc.domain;

import javax.persistence.*;

/**
 * 图片
 * Created by Administrator on 2015/8/26.
 */
@Entity
@Table(name = "tb_picture")
public class Picture {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String picpath;

    @Column(nullable = false)
    private String addtime;

    @ManyToOne
    @JoinColumn(name = "atlas_id")
    private Atlas atlas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPicpath() {
        return picpath;
    }

    public void setPicpath(String picpath) {
        this.picpath = picpath;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }

    public Atlas getAtlas() {
        return atlas;
    }

    public void setAtlas(Atlas atlas) {
        this.atlas = atlas;
    }

}
