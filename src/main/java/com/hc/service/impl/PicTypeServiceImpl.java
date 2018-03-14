package com.hc.service.impl;

import com.hc.dao.PicTypeRepository;
import com.hc.domain.PicType;
import com.hc.exception.ServiceException;
import com.hc.service.PicTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 * @date 2015/9/26
 */
@Service
public class PicTypeServiceImpl implements PicTypeService {

    @Autowired
    private PicTypeRepository picTypeRepository;

    @Override
    public List<PicType> getAll() {
        return (List<PicType>) picTypeRepository.findAll();
    }

    @Override
    public PicType findOne(long id) {
        return picTypeRepository.findById(id).orElseThrow(ServiceException::new);
    }

    @Override
    public PicType save(PicType picType) {
        return picTypeRepository.save(picType);
    }

    @Override
    public void delete(long id) {
        picTypeRepository.deleteById(id);
    }


}

