package com.hc.service.impl;

import com.hc.dao.PictureRepository;
import com.hc.domain.Picture;
import com.hc.exception.ServiceException;
import com.hc.service.PictureService;
import com.hc.utils.UpYunUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Administrator on 2015/9/5.
 */
@Component("pictureService")
@Transactional
public class PictureServiceImpl implements PictureService {

    @Autowired
    PictureRepository pictureRepository;

    @Override
    public Page<Picture> findAll(Pageable pageable) {
        Page<Picture> pictures = pictureRepository.findAll(pageable);
        return pictures;
    }

    @Override
    public Page<Picture> findByPicpathLike(String pictureName, Pageable pageable) {
        return pictureRepository.findByPicpathLike(pictureName, pageable);
    }

    @Override
    public Picture save(Picture picture) {
        return pictureRepository.save(picture);
    }

    @Override
    public List<Picture> findPicturesByAtlasId(long id) {
        return pictureRepository.findByAtlasId(id);
    }

    @Override
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

    @Override
    public Picture findOne(long id) {
        return pictureRepository.findById(id).orElseThrow(ServiceException::new);
    }
}
