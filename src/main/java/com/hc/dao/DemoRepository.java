package com.hc.dao;

import com.hc.domain.DemoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoRepository extends CrudRepository<DemoEntity, Integer> {

}
