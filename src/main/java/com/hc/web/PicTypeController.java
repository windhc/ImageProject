package com.hc.web;

import com.hc.domain.PicType;
import com.hc.service.PicTypeService;
import com.hc.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Map save(@RequestBody PicType picType) {
        picTypeService.save(picType);
        return CommonUtil.response(true, "分类添加成功");
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Map update(@RequestBody PicType picType) {
        picTypeService.save(picType);
        return CommonUtil.response(true, "分类更新成功");
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public Map save(@PathVariable("id") long id) {
        picTypeService.delete(id);
        return CommonUtil.response(true, "分类删除成功");
    }
}
