package com.hc.service.impl;

import com.hc.dao.PictureRepository;
import com.hc.dao.TagRepository;
import com.hc.domain.Picture;
import com.hc.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

/**
 * Created by Administrator on 2015/9/5.
 */
@Component("pictureService")
@Transactional
public class PictureServiceImpl implements PictureService {

    @Autowired
    PictureRepository pictureRepository;

    @Autowired
    TagRepository tagRepository;

    @Override
    public Page<Picture> findAll(Pageable pageable) {
        Page<Picture> pictures = pictureRepository.findAll(pageable);
        return pictures;
    }

    @Override
    public Picture save(Picture picture) {
        return pictureRepository.save(picture);
    }
}
