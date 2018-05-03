package com.windhc.web;

import com.windhc.domain.Tag;
import com.windhc.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Administrator
 * @date 2015/9/27
 */
@RestController
@RequestMapping(value = "/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping(value = "/listTagAll")
    public List<Tag> getPicTypeAll(){
        return tagService.findAll();
    }

    @GetMapping(value = "/pictypetag/{pictypeId}")
    public List<Tag> getPicTypeTag(@PathVariable("pictypeId") long picTypeId){
        return tagService.findByPicTypeId(picTypeId);
    }

    @GetMapping(value = "/{id}")
    public Tag findOne(@PathVariable("id") long id) {
        return tagService.findOne(id);
    }

    @PostMapping(value = "/save")
    public void save(@RequestBody Tag tag) {
        tagService.save(tag);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable("id") long id) {
        tagService.delete(id);
    }

    @PostMapping(value = "/update")
    public void update(@RequestBody Tag tag) {
        tagService.save(tag);
    }
}
