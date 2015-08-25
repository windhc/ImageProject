package com.hc.dao;

import com.hc.domain.DemoEntity;
import org.springframework.data.repository.CrudRepository;

public interface DemoRepository extends CrudRepository<DemoEntity, Integer> {

}
