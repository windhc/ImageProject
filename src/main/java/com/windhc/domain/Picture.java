package com.windhc.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 图片
 * Created by Administrator on 2015/8/26.
 */
@Table(name = "tb_picture")
public class Picture {

    @Id
    @GeneratedValue
    private Long id;

    private String picpath;

    private String addtime;

    private Long atlasId;

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

    public Long getAtlasId() {
        return atlasId;
    }

    public void setAtlasId(Long atlasId) {
        this.atlasId = atlasId;
    }

    public Atlas getAtlas() {
        return atlas;
    }

    public void setAtlas(Atlas atlas) {
        this.atlas = atlas;
    }
}
