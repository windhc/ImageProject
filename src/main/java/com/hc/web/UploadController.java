package com.hc.web;

import com.hc.exception.ServiceException;
import com.hc.service.FileStoreService;
import com.hc.utils.UpYunUtil;
import main.java.com.UpYun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartRequest;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Administrator on 2015/9/20.
 */
@RestController
@RequestMapping("/web/upload")
public class UploadController {

    @Autowired
    private FileStoreService fileStoreService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Map<String,Object> index(MultipartRequest request){

        return fileStoreService.saveFile(request);
    }

    //用于上传时删除
    @RequestMapping(value = "/delete/{filename:.*}", method = RequestMethod.GET)
    public String deleteUploadFile(@PathVariable("filename")String filename){
        UpYun upYun = UpYunUtil.getUpYun();
        boolean result = upYun.deleteFile(UpYunUtil.getUpYunFileSavePath(upYun) + filename);
        if(result){
            return "success";
        }
        return "fail";
    }

    @ExceptionHandler(ServiceException.class)
    public Map<String,Object> serviceExceptionHandler(ServiceException e) {
        e.printStackTrace();
        Map model = new TreeMap();
        model.put("status", false);
        System.out.println("ServiceException");
        return model;
    }
}
