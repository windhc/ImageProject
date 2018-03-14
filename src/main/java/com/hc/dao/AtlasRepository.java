package com.hc.dao;

import com.hc.domain.Atlas;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author windhc
 */
@Repository
public interface AtlasRepository extends JpaRepository<Atlas, Long> {

    Page<Atlas> findAll(Pageable pageable);

    Page<Atlas> findByAtlasLike(String atlas, Pageable pageable);

    Page<Atlas> findByPicTypeId(long typeId, Pageable pageable);

    Page<Atlas> findByTagsIn(List tagIds, Pageable pageable);
}
