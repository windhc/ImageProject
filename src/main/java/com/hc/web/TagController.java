package com.hc.web;

import com.hc.domain.Tag;
import com.hc.service.TagService;
import com.hc.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    public Map save(@RequestBody Tag tag) {
        tagService.save(tag);
        return CommonUtil.response(true, "标签添加成功");
    }

    @GetMapping(value = "/delete/{id}")
    public Map delete(@PathVariable("id") long id) {
        tagService.delete(id);
        return CommonUtil.response(true, "标签删除成功");
    }

    @PostMapping(value = "/update")
    public Map update(@RequestBody Tag tag) {
        tagService.save(tag);
        return CommonUtil.response(true, "标签修改成功");
    }
}
