package com.windhc.web;

import com.windhc.domain.PictureType;
import com.windhc.service.PicTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Administrator
 * @date 2015/9/26
 */
@RestController
@RequestMapping(value = "/pictype")
public class PicTypeController {

    @Autowired
    private PicTypeService picTypeService;

    @GetMapping(value = "/list")
    public List<PictureType> getAll(){
        return picTypeService.getAll();
    }

    @PostMapping(value = "/save")
    public void save(@RequestBody PictureType pictureType) {
        picTypeService.save(pictureType);
    }

    @PostMapping(value = "/update")
    public void update(@RequestBody PictureType pictureType) {
        picTypeService.save(pictureType);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable("id") long id) {
        picTypeService.delete(id);
    }
}
