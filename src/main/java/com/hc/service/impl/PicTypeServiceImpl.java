package com.hc.service.impl;

import com.hc.dao.PicTypeRepository;
import com.hc.domain.PicType;
import com.hc.service.PicTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2015/9/26.
 */
@Service
public class PicTypeServiceImpl implements PicTypeService {

    @Autowired
    PicTypeRepository picTypeRepository;

    @Override
    public List<PicType> getAll() {
        return (List<PicType>) picTypeRepository.findAll();
    }

    @Override
    public PicType findOne(long id) {
        return picTypeRepository.findOne(id);
    }


}

