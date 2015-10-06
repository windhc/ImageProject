package com.hc.web;

import com.hc.domain.PicType;
import com.hc.service.PicTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2015/9/26.
 */
@RestController
@RequestMapping(value = "/pictype")
public class PicTypeController {

    @Autowired
    PicTypeService picTypeService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<PicType> getAll(){
        return picTypeService.getAll();
    }
}
