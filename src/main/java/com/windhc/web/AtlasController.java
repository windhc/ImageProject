package com.windhc.web;

import com.github.pagehelper.PageInfo;
import com.windhc.domain.Atlas;
import com.windhc.domain.Tag;
import com.windhc.service.AtlasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * @date 2015/9/5
 */
@RestController
@RequestMapping("/atlas")
public class AtlasController {

    @Autowired
    private AtlasService atlasService;

    @GetMapping(value = "/delete/{id}")
    public void delete(@PathVariable("id") long id){
        atlasService.delete(id);
    }

    @GetMapping(value = "/detail/{id}")
    public Atlas detail(@PathVariable("id") long id){
        return atlasService.findOne(id);
    }

    @GetMapping(value = "/tag/{atlasId}")
    public List<Tag> getAtlasTag(@PathVariable("atlasId") long atlasId){
        return atlasService.atlasTag(atlasId);
    }

    @PostMapping(value = "/save")
    public void save(@RequestBody Map<String,Object> params){
        atlasService.saveForForm(params);
    }

    @GetMapping(value = "/atlasPage")
    public PageInfo<Atlas> getAllPicture(@RequestParam() Map pageParams) {
//        PageRequest pageRequest = CommonUtil.buildPageRequest(pageParams);
//        String filterValue = (String) pageParams.get("filter[atlas]");
//        Object typeId = pageParams.get("type");
//        if (!StringUtils.isEmpty(filterValue)){
//            return atlasService.findByAtlasName("%" + filterValue + "%", pageRequest);
//        }
//        if (typeId != null){
//            return atlasService.findByPicType(Long.parseLong(String.valueOf(typeId)), pageRequest);
//        }
//        return atlasService.findAll(pageRequest);
        return null;
    }

    @PostMapping(value = "/update")
    public void update(@RequestBody Map<String,Object> params) {
        atlasService.updateForForm(params);
    }

    /**
     * 前端相册分页获取
     */
    @GetMapping(value = "/front/atlasPage")
    public PageInfo<Atlas> getPictures(@RequestParam() Map pageParams) {
//        PageRequest pageRequest = CommonUtil.buildPageRequest(pageParams);
//        Object typeId = pageParams.get("type");
//        Object tag = pageParams.get("tag");
//        if (typeId != null){
//            return atlasService.findByPicType(Long.parseLong(String.valueOf(typeId)), pageRequest);
//        }
//        if (tag != null){
//            char[] chars = String.valueOf(tag).toCharArray();
//            List<Long> tagIds = new ArrayList<>();
//            for (char c : chars) {
//                tagIds.add(Long.valueOf(String.valueOf(c)));
//            }
//            return atlasService.findByTagIds(tagIds, pageRequest);
//        }
//        return atlasService.findAll(pageRequest);
        return null;
    }

}
