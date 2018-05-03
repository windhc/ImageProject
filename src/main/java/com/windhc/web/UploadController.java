package com.windhc.web;

import com.windhc.service.FileStoreService;
import com.windhc.utils.UpYunUtil;
import main.java.com.UpYun;
import main.java.com.upyun.UpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartRequest;

import java.io.IOException;
import java.util.Map;

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
}
