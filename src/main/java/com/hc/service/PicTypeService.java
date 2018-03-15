package com.hc.service;

import com.hc.dao.PicTypeRepository;
import com.hc.domain.PicType;
import com.hc.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 * @date 2015/9/26
 */
@Service
public class PicTypeService {

    @Autowired
    private PicTypeRepository picTypeRepository;

    public List<PicType> getAll() {
        return picTypeRepository.findAll();
    }

    public PicType findOne(long id) {
        return picTypeRepository.findById(id).orElseThrow(ServiceException::new);
    }

    public PicType save(PicType picType) {
        return picTypeRepository.save(picType);
    }

    public void delete(long id) {
        picTypeRepository.deleteById(id);
    }

}

