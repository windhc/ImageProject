package com.hc.dao;

import com.hc.domain.Picture;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author windhc
 */
@Repository
public interface PictureRepository extends JpaRepository<Picture, Long> {

    Page<Picture> findAll(Pageable pageable);

    Page<Picture> findByPicpathLike(String pictureName, Pageable pageable);

    List<Picture> findByAtlasId(long id);

}
