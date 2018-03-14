package com.hc.dao;

import com.hc.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author windhc
 */
@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {

}
