package com.windhc.service;

import com.windhc.dao.PicTypeMapper;
import com.windhc.domain.PicType;
import com.windhc.exception.ServiceException;
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
    private PicTypeMapper picTypeMapper;

    public List<PicType> getAll() {
        return picTypeMapper.findAll();
    }

    public PicType findOne(long id) {
        return picTypeMapper.findById(id).orElseThrow(ServiceException::new);
    }

    public PicType save(PicType picType) {
        return picTypeMapper.save(picType);
    }

    public void delete(long id) {
        picTypeMapper.deleteById(id);
    }

}

