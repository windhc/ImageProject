package com.hc.dao;

import com.hc.domain.Atlas;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtlasRepository extends CrudRepository<Atlas, Integer> {

}
