package com.hc.web;

import com.hc.domain.Atlas;
import com.hc.service.AtlasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by Administrator on 2015/9/5.
 */
@RestController
@RequestMapping("/atlas")
public class AtlasController {

    @Autowired
    AtlasService atlasService;

    @RequestMapping(value = "/atlasPage", method = RequestMethod.GET)
    public Page<Atlas> getAllPicture(@RequestParam() Map pageParams) {

        PageRequest pageRequest = buildPageRequest(pageParams);
        for(Object key : pageParams.keySet()){
            System.out.println("key= " + key + "  and  value= " + pageParams.get(key));
        }

        String filterValue = (String) pageParams.get("filter[atlas]");
        if (filterValue!=null){
            return atlasService.findByAtlas("%"+filterValue+"%",pageRequest);
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
