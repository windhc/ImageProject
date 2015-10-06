package com.hc.dao;

import com.hc.domain.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {

    Page<Tag> findAll(Pageable pageable);

    List<Tag> findByPicTypeId(long picTypeId);
}
