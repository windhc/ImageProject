package com.hc.dao;

import com.hc.domain.Picture;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PictureRepository extends PagingAndSortingRepository<Picture, Long> {

    Page<Picture> findAll(Pageable pageable);

    Page<Picture> findByPicpathLike(String pictureName, Pageable pageable);

    List<Picture> findByAtlasId(long id);

}
