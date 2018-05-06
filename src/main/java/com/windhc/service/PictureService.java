package com.windhc.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.windhc.config.upyun.UpYunService;
import com.windhc.dao.PictureMapper;
import com.windhc.domain.Picture;
import com.windhc.utils.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 * @date 2015/9/5
 */
@Service
public class PictureService {

    @Autowired
    private PictureMapper pictureMapper;

    @Autowired
    private UpYunService upYunService;

    public PageInfo<Picture> findAll(PageRequest pageRequest) {
        return PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize())
                .doSelectPageInfo(() -> pictureMapper.selectAll());
    }

//    public Page<Picture> findByPicPathLike(String pictureName, Pageable pageable) {
//        return pictureMapper.findByPicpathLike(pictureName, pageable);
//    }

    public void save(Picture picture) {
        pictureMapper.insertSelective(picture);
    }

    public List<Picture> findPicturesByAtlasId(long id) {
        return pictureMapper.findByAtlasId(id);
    }

    public void delete(long id) {
        Picture picture = pictureMapper.selectByPrimaryKey(id);
        String picPath = picture.getPath();
        picPath = picPath.substring(picPath.lastIndexOf("http://imagestore.b0.upaiyun.com") + 32);
        pictureMapper.deleteByPrimaryKey(id);

        upYunService.deleteFile(picPath);
    }

    public Picture findOne(long id) {
        return pictureMapper.selectByPrimaryKey(id);
    }
}
