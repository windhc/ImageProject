package com.hc.service;

import com.hc.dao.PictureRepository;
import com.hc.domain.Picture;
import com.hc.exception.ServiceException;
import com.hc.utils.UpYunUtil;
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
    private PictureRepository pictureRepository;

    public Page<Picture> findAll(Pageable pageable) {
        Page<Picture> pictures = pictureRepository.findAll(pageable);
        return pictures;
    }

    public Page<Picture> findByPicPathLike(String pictureName, Pageable pageable) {
        return pictureRepository.findByPicPathLike(pictureName, pageable);
    }

    public Picture save(Picture picture) {
        return pictureRepository.save(picture);
    }

    public List<Picture> findPicturesByAtlasId(long id) {
        return pictureRepository.findByAtlasId(id);
    }

    public Boolean delete(long id) {
        Picture picture = pictureRepository.findById(id).orElseThrow(ServiceException::new);
        String picPath = picture.getPicpath();
        picPath = picPath.substring(picPath.lastIndexOf("http://imagestore.b0.upaiyun.com")+32);
        pictureRepository.deleteById(id);
        try {
            return UpYunUtil.getUpYun().deleteFile(picPath);
        } catch (Exception e){
            throw new ServiceException("删除文件出错");
        }
    }

    public Picture findOne(long id) {
        return pictureRepository.findById(id).orElseThrow(ServiceException::new);
    }
}
