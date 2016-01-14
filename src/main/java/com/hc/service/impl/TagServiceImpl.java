package com.hc.service.impl;

import com.hc.dao.TagRepository;
import com.hc.domain.Tag;
import com.hc.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Administrator on 2015/9/5.
 */
@Component("tagService")
@Transactional
public class TagServiceImpl implements TagService {

    @Autowired
    TagRepository tagRepository;

    @Override
    public List<Tag> findAll() {
        return (List<Tag>) tagRepository.findAll();
    }

    @Override
    public List<Tag> findByPicTypeId(long picTypeId) {
        return tagRepository.findByPicTypeId(picTypeId);
    }

    @Override
    public Tag findOne(long id) {
        return tagRepository.findOne(id);
    }

    @Override
    public Tag save(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public void delete(long id) {
        tagRepository.delete(id);
    }

}
