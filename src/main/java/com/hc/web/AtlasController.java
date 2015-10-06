package com.hc.web;

import com.hc.domain.Atlas;
import com.hc.domain.Picture;
import com.hc.domain.Tag;
import com.hc.service.*;
import com.hc.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/9/5.
 */
@RestController
@RequestMapping("/atlas")
public class AtlasController {

    @Autowired
    AtlasService atlasService;

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public void delete(@PathVariable("id") long id){
        atlasService.delete(id);
    }

    @RequestMapping(value = "/tag/{atlasId}",method = RequestMethod.GET)
    public List<Tag> getAtlasTag(@PathVariable("atlasId") long atlasId){
        return atlasService.atlasTag(atlasId);
    }

    @Transactional
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Map getAtlasPicType(@RequestBody Map<String,Object> params){
        atlasService.saveForForm(params);
        return CommonUtil.response(true,"添加成功！");
    }

    @RequestMapping(value = "/atlasPage", method = RequestMethod.GET)
    public Page<Atlas> getAllPicture(@RequestParam() Map pageParams) {

        PageRequest pageRequest = buildPageRequest(pageParams);
        String filterValue = (String) pageParams.get("filter[atlas]");
        if (filterValue!=null){
            return atlasService.findByAtlasName("%" + filterValue + "%", pageRequest);
        }
        return atlasService.findAll(pageRequest);
    }

    /**
     * 创建分页请求.
     */
    private PageRequest buildPageRequest(Map pageParams) {

        int page = 1;
        int count = 1;
        Sort sort = null;

        for(Object key : pageParams.keySet()){
            String paramKey = (String)key;
            if (paramKey.equals("page")){
                page = Integer.valueOf((String)pageParams.get(paramKey));
            }
            if (paramKey.equals("count")){
                count = Integer.valueOf((String)pageParams.get(paramKey));
            }
            if (paramKey.startsWith("sorting[")){
                String sortKey = paramKey.substring(paramKey.indexOf("[")+1,paramKey.lastIndexOf("]"));
                String sortType = (String)pageParams.get(paramKey);

                if(sortType.equals("asc")){
                    sort = new Sort(Sort.Direction.ASC, sortKey);
                }
                if(sortType.equals("desc")){
                    sort = new Sort(Sort.Direction.DESC, sortKey);
                }
            }
        }
        return new PageRequest(page-1, count, sort);
    }

}
