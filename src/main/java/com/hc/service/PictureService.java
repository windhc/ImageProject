package com.hc.service;

import com.hc.domain.Picture;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Administrator on 2015/9/5.
 */
public interface PictureService {

    Page<Picture> findAll(Pageable pageable);

    Page<Picture> findByPicpathLike(String pictureName, Pageable pageable);

    Picture save(Picture picture);

    List<Picture> findPicturesByAtlasId(long id);

    Boolean delete(long id);

    Picture findOne(long id);
}
