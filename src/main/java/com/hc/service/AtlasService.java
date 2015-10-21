package com.hc.service;

import com.hc.domain.Atlas;
import com.hc.domain.PicType;
import com.hc.domain.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/9/5.
 */
public interface AtlasService {

    /**
     * 删除图册
     * @param id 要删除的图册ID
     */
    void delete(long id);

    /**
     * 根据图册ID获得图册标签
     * @param atlasId 图册ID
     * @return 该图册的所有标签
     */
    List<Tag> atlasTag(long atlasId);

    /**
     * 分页得到所有的图册
     * @param pageable 分页参数
     * @return 图册分页
     */
    Page<Atlas> findAll(Pageable pageable);

    /**
     * 根据图册名称模糊查询
     * @param atlasname 图册名称模糊查询参数
     * @param pageable 分页参数
     * @return 模糊查询所得图册分页
     */
    Page<Atlas> findByAtlasName(String atlasname, Pageable pageable);

    /**
     * 保存图册
     * @param atlas
     * @return 所保存的图册
     */
    Atlas save(Atlas atlas);

    Atlas saveForForm(Map<String,Object> params);

    Atlas findOne(long id);

    Atlas updateForForm(Map<String, Object> params);
}
