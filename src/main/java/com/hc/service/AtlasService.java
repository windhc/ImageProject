package com.hc.service;

import com.hc.domain.Atlas;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by Administrator on 2015/9/5.
 */
public interface AtlasService {

    public Page<Atlas> findAll(Pageable pageable);

    public Page<Atlas> findByAtlas(String atlas, Pageable pageable);

}
