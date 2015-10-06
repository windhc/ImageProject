package com.hc.service;

import com.hc.domain.PicType;

import java.util.List;

/**
 * Created by Administrator on 2015/9/26.
 */
public interface PicTypeService {

    public List<PicType> getAll();

    public PicType findOne(long id);

}
