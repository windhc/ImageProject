package com.hc.dao;

import com.hc.domain.PicType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author windhc
 */
@Repository
public interface PicTypeRepository extends JpaRepository<PicType, Long> {

}
