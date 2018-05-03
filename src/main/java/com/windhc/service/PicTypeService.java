package com.windhc.service;

import com.windhc.dao.PicTypeMapper;
import com.windhc.domain.PicType;
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
        return picTypeMapper.selectAll();
    }

    public PicType findOne(long id) {
        return picTypeMapper.selectByPrimaryKey(id);
    }

    public void save(PicType picType) {
        picTypeMapper.insertSelective(picType);
    }

    public void delete(long id) {
        picTypeMapper.deleteByPrimaryKey(id);
    }

}

