package com.windhc.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.windhc.dao.PictureMapper;
import com.windhc.domain.Picture;
import com.windhc.exception.ServiceException;
import com.windhc.utils.PageRequest;
import com.windhc.utils.UpYunUtil;
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
        String picPath = picture.getPicpath();
        picPath = picPath.substring(picPath.lastIndexOf("http://imagestore.b0.upaiyun.com")+32);
        pictureMapper.deleteByPrimaryKey(id);
        try {
            UpYunUtil.getUpYun().deleteFile(picPath);
        } catch (Exception e){
            throw new ServiceException("删除文件出错");
        }
    }

    public Picture findOne(long id) {
        return pictureMapper.selectByPrimaryKey(id);
    }
}
