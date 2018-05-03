package com.windhc.web;

import com.github.pagehelper.PageInfo;
import com.windhc.domain.Picture;
import com.windhc.service.PictureService;
import com.windhc.service.TagService;
import com.windhc.utils.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Administrator
 * @date 2015/9/5
 */
@RestController
@RequestMapping("/picture")
public class PictureController {

    @Autowired
    private PictureService pictureService;

    @Autowired
    private TagService tagService;

    @GetMapping(value = "/byatlasid/{id}")
    public List<Picture> getPictureByAtlasId(@PathVariable("id") long id) {
        return pictureService.findPicturesByAtlasId(id);
    }

    @GetMapping(value = "/picturePage")
    public PageInfo<Picture> getAllPicture(PageRequest pageRequest) {
        return pictureService.findAll(pageRequest);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable("id") long id){
        pictureService.delete(id);
    }
}
