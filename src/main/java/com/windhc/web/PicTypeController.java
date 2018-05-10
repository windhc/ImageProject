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
@RequestMapping(value = "/pictureType")
public class PicTypeController {

    @Autowired
    private PicTypeService picTypeService;

    @GetMapping(value = "")
    public List<PictureType> getAll(){
        return picTypeService.getAll();
    }

    @PostMapping(value = "")
    public void save(@RequestBody PictureType pictureType) {
        picTypeService.save(pictureType);
    }

    @PutMapping(value = "")
    public void update(@RequestBody PictureType pictureType) {
        picTypeService.save(pictureType);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") long id) {
        picTypeService.delete(id);
    }
}
