package com.hc.dao;

import com.hc.domain.PicType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PicTypeRepository extends CrudRepository<PicType, Long> {

}
