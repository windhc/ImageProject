package com.windhc.service;

import com.windhc.dao.TagMapper;
import com.windhc.domain.Tag;
import com.windhc.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author Administrator
 * @date 2015/9/5
 */
@Service
public class TagService {

    @Autowired
    private TagMapper tagMapper;

    public List<Tag> findAll() {
        return tagMapper.findAll();
    }

    public List<Tag> findByPicTypeId(long picTypeId) {
        return tagMapper.findByPicTypeId(picTypeId);
    }

    public Tag findOne(long id) {
        return tagMapper.findById(id).orElseThrow(ServiceException::new);
    }

    public Tag save(Tag tag) {
        return tagMapper.save(tag);
    }

    public void delete(long id) {
        tagMapper.deleteById(id);
    }

}
