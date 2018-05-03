package com.windhc.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 图片
 *
 * @author Administrator
 * @date 2015/8/26
 */
@Table(name = "tb_picture")
public class Picture {

    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    private String path;

    private Long atlasId;

    private Long createdAt;

    private Atlas atlas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
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
