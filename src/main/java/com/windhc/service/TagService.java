package com.windhc.service;

import com.windhc.dao.TagMapper;
import com.windhc.domain.Tag;
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
        return tagMapper.selectAll();
    }

    public List<Tag> findByPicTypeId(long picTypeId) {
        return tagMapper.findByPicTypeId(picTypeId);
    }

    public Tag findOne(long id) {
        return tagMapper.selectByPrimaryKey(id);
    }

    public void save(Tag tag) {
        tagMapper.insertSelective(tag);
    }

    public void delete(long id) {
        tagMapper.deleteByPrimaryKey(id);
    }

}
