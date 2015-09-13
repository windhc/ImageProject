package com.hc.service.impl;

import com.hc.dao.AtlasRepository;
import com.hc.domain.Atlas;
import com.hc.service.AtlasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

/**
 * Created by Administrator on 2015/9/5.
 */
@Component("atlasService")
@Transactional
public class AtlasServiceImpl implements AtlasService {

    @Autowired
    AtlasRepository atlasRepository;

    @Override
    public Page<Atlas> findAll(Pageable pageable) {
        Page<Atlas> atlases = atlasRepository.findAll(pageable);
        return atlases;
    }

    @Override
    public Page<Atlas> findByAtlas(String atlas, Pageable pageable) {
        return atlasRepository.findByAtlasLike(atlas, pageable);
    }
}
