package com.windhc.dao;

import com.windhc.domain.Picture;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author windhc
 */
@Mapper
public interface PictureMapper extends tk.mybatis.mapper.common.Mapper<Picture> {

    List<Picture> findByAtlasId(long id);

}
