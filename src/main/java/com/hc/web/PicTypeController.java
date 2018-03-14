package com.hc.web;

import com.hc.domain.PicType;
import com.hc.service.PicTypeService;
import com.hc.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    public List<PicType> getAll(){
        return picTypeService.getAll();
    }

    @PostMapping(value = "/save")
    public Map save(@RequestBody PicType picType) {
        picTypeService.save(picType);
        return CommonUtil.response(true, "分类添加成功");
    }

    @PostMapping(value = "/update")
    public Map update(@RequestBody PicType picType) {
        picTypeService.save(picType);
        return CommonUtil.response(true, "分类更新成功");
    }

    @GetMapping(value = "/delete/{id}")
    public Map save(@PathVariable("id") long id) {
        picTypeService.delete(id);
        return CommonUtil.response(true, "分类删除成功");
    }
}
