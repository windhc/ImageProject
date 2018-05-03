package com.windhc.service;

import com.windhc.dao.PictureMapper;
import com.windhc.domain.Picture;
import com.windhc.exception.ServiceException;
import com.windhc.utils.UpYunUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public Page<Picture> findAll(Pageable pageable) {
        Page<Picture> pictures = pictureMapper.findAll(pageable);
        return pictures;
    }

    public Page<Picture> findByPicPathLike(String pictureName, Pageable pageable) {
        return pictureMapper.findByPicpathLike(pictureName, pageable);
    }

    public Picture save(Picture picture) {
        return pictureMapper.save(picture);
    }

    public List<Picture> findPicturesByAtlasId(long id) {
        return pictureMapper.findByAtlasId(id);
    }

    public Boolean delete(long id) {
        Picture picture = pictureMapper.findById(id).orElseThrow(ServiceException::new);
        String picPath = picture.getPicpath();
        picPath = picPath.substring(picPath.lastIndexOf("http://imagestore.b0.upaiyun.com")+32);
        pictureMapper.deleteById(id);
        try {
            return UpYunUtil.getUpYun().deleteFile(picPath);
        } catch (Exception e){
            throw new ServiceException("删除文件出错");
        }
    }

    public Picture findOne(long id) {
        return pictureMapper.findById(id).orElseThrow(ServiceException::new);
    }
}
