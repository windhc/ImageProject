package com.hc.web;

import com.hc.domain.Picture;
import com.hc.service.PictureService;
import com.hc.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2015/9/5.
 */
@RestController
@RequestMapping("/picture")
public class PictureController {

    @Autowired
    PictureService pictureService;

    @Autowired
    TagService tagService;

    @RequestMapping(value = "/picturePage", method = RequestMethod.GET)
    public Page<Picture> getAllPicture(int pageNumber, int pageSize) {

//        PageRequest pageRequest = buildPageRequest(pageNumber, pageSize, sortType);

        Page<Picture> pictures = pictureService.findAll(new PageRequest(pageNumber, pageSize));
        return pictures;
    }

    /**
     * 创建分页请求.
     */
//    private PageRequest buildPageRequest(int pageNumber, int pagzSize, String sortType) {
//        Sort sort = null;
//        if ("auto".equals(sortType)) {
//            sort = new Sort(Direction.DESC, "id");
//        } else if ("title".equals(sortType)) {
//            sort = new Sort(Direction.ASC, "title");
//        }
//
//        return new PageRequest(pageNumber - 1, pagzSize, sort);
//    }

}
