package com.hc.service;

import com.hc.dao.TagRepository;
import com.hc.domain.Tag;
import com.hc.exception.ServiceException;
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
    private TagRepository tagRepository;

    public List<Tag> findAll() {
        return tagRepository.findAll();
    }

    public List<Tag> findByPicTypeId(long picTypeId) {
        return tagRepository.findByPicTypeId(picTypeId);
    }

    public Tag findOne(long id) {
        return tagRepository.findById(id).orElseThrow(ServiceException::new);
    }

    public Tag save(Tag tag) {
        return tagRepository.save(tag);
    }

    public void delete(long id) {
        tagRepository.deleteById(id);
    }

}
