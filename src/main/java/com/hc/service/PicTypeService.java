package com.hc.service;

import com.hc.domain.PicType;

import java.util.List;

/**
 * @author Administrator
 * @date 2015/9/26
 */
public interface PicTypeService {

    List<PicType> getAll();

    PicType findOne(long id);

    PicType save(PicType picType);

    void delete(long id);

}
