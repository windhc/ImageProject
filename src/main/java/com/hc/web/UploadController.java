package com.hc.web;

import com.hc.exception.ServiceException;
import com.hc.service.FileStoreService;
import com.hc.utils.UpYunUtil;
import main.java.com.UpYun;
import main.java.com.upyun.UpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartRequest;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Administrator
 * @date 2015/9/20
 */
@RestController
@RequestMapping("/web/upload")
public class UploadController {

    @Autowired
    private FileStoreService fileStoreService;

    @PostMapping(value = "")
    public Map<String,Object> index(MultipartRequest request){
        return fileStoreService.saveFile(request);
    }

    /**
     * 用于上传时删除
     */
    @GetMapping(value = "/delete/{filename:.*}")
    public String deleteUploadFile(@PathVariable("filename") String filename){
        UpYun upYun = UpYunUtil.getUpYun();
        boolean result = false;
        try {
            result = upYun.deleteFile(UpYunUtil.getUpYunFileSavePath(upYun) + filename);
        } catch (IOException | UpException e) {
            e.printStackTrace();
        }
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
