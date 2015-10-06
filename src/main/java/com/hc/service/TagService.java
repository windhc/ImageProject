package com.hc.service;

import com.hc.domain.Tag;

import java.util.List;

/**
 * Created by Administrator on 2015/9/5.
 */
public interface TagService {

    public List<Tag> findAll();

    public List<Tag> findByPicTypeId(long picTypeId);

    public Tag findOne(long id);
}
