package com.hc.service;

import com.hc.domain.Picture;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by Administrator on 2015/9/5.
 */
public interface PictureService {

    public Page<Picture> findAll(Pageable pageable);

    public Picture save(Picture picture);

}
