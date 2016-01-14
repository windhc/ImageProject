package com.hc.service;

import com.hc.domain.Tag;

import java.util.List;

/**
 * Created by Administrator on 2015/9/5.
 */
public interface TagService {

    List<Tag> findAll();

    List<Tag> findByPicTypeId(long picTypeId);

    Tag findOne(long id);

    Tag save(Tag tag);

    void delete(long id);
}
