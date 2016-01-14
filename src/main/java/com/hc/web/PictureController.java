package com.hc.web;

import com.hc.domain.Picture;
import com.hc.exception.ServiceException;
import com.hc.service.PictureService;
import com.hc.service.TagService;
import com.hc.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @RequestMapping(value = "/byatlasid/{id}", method = RequestMethod.GET)
    public List<Picture> getPictureByAtlasId(@PathVariable("id") long id) {
        return pictureService.findPicturesByAtlasId(id);
    }

    @RequestMapping(value = "/picturePage", method = RequestMethod.GET)
    public Page<Picture> getAllPicture(@RequestParam() Map pageParams) {
        PageRequest pageRequest = CommonUtil.buildPageRequest(pageParams);
        String filterValue = (String) pageParams.get("filter[picture]");
        if (filterValue!=null){
            return pictureService.findByPicpathLike("%" + filterValue + "%", pageRequest);
        }
        return pictureService.findAll(pageRequest);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public Map delete(@PathVariable("id") long id){
        boolean result = pictureService.delete(id);
        return CommonUtil.response(result, result ? "删除成功" : "删除失败");
    }

    @ExceptionHandler(ServiceException.class)
    public Map<String,Object> serviceExceptionHandler(ServiceException e) {
        e.printStackTrace();
        System.out.println("ServiceException");
        return CommonUtil.response(false, e.getMessage());
    }

}
