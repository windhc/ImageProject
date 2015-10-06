package com.hc.web;

import com.hc.domain.Tag;
import com.hc.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2015/9/27.
 */
@RestController
@RequestMapping(value = "/tag")
public class TagController {

    @Autowired
    TagService tagService;

    @RequestMapping(value = "/listTagAll",method = RequestMethod.GET)
    public List<Tag> getPicTypeAll(){

        return tagService.findAll();
    }

    @RequestMapping(value = "/pictypetag/{pictypeId}",method = RequestMethod.GET)
    public List<Tag> getPicTypeTag(@PathVariable("pictypeId") long picTypeId){

        return tagService.findByPicTypeId(picTypeId);
    }
}
