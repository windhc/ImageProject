package com.hc.service.impl;

import com.hc.dao.TagRepository;
import com.hc.domain.Tag;
import com.hc.exception.ServiceException;
import com.hc.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author Administrator
 * @date 2015/9/5
 */
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;

    @Override
    public List<Tag> findAll() {
        return tagRepository.findAll();
    }

    @Override
    public List<Tag> findByPicTypeId(long picTypeId) {
        return tagRepository.findByPicTypeId(picTypeId);
    }

    @Override
    public Tag findOne(long id) {
        return tagRepository.findById(id).orElseThrow(ServiceException::new);
    }

    @Override
    public Tag save(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public void delete(long id) {
        tagRepository.deleteById(id);
    }

}
