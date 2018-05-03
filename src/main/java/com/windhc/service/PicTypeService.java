package com.windhc.service;

import com.windhc.dao.PicTypeMapper;
import com.windhc.domain.PictureType;
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

    public List<PictureType> getAll() {
        return picTypeMapper.selectAll();
    }

    public PictureType findOne(long id) {
        return picTypeMapper.selectByPrimaryKey(id);
    }

    public void save(PictureType pictureType) {
        picTypeMapper.insertSelective(pictureType);
    }

    public void delete(long id) {
        picTypeMapper.deleteByPrimaryKey(id);
    }

}

