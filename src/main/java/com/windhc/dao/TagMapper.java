package com.windhc.dao;

import com.windhc.domain.Tag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author windhc
 */
@Mapper
public interface TagMapper extends tk.mybatis.mapper.common.Mapper<Tag> {

    List<Tag> findByPicTypeId(long picTypeId);
}
