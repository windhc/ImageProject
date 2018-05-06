package com.windhc.web;

import com.windhc.config.upyun.UpYunService;
import com.windhc.service.FileStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartRequest;

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

    @Autowired
    private UpYunService upYunService;

    @PostMapping(value = "")
    public Map<String,Object> index(MultipartRequest request){
        return fileStoreService.saveFile(request);
    }

    /**
     * 用于上传时删除
     */
    @DeleteMapping(value = "/delete/{filePath:.*}")
    public void deleteUploadFile(@PathVariable("filePath") String filePath){
        upYunService.deleteFile(filePath);
    }
}
