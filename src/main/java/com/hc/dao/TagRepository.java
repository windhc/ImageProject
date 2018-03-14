package com.hc.dao;

import com.hc.domain.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author windhc
 */
@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

    Page<Tag> findAll(Pageable pageable);

    List<Tag> findByPicTypeId(long picTypeId);
}
