package com.windhc.service;

import com.windhc.exception.ServiceException;
import com.windhc.utils.UpYunUtil;
import main.java.com.UpYun;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import java.io.File;
import java.util.*;

/**
 * @author Administrator
 * @date 2015/9/22
 */
@Service
public class FileStoreService {

    public Map<String, Object> saveFile(MultipartRequest request) {
        String uploadPath = this.getClass().getClassLoader().getResource("static/upload/").getPath();

        List<Map> files = new ArrayList<>();
        Iterator<String> fileNames = request.getFileNames();
        while (fileNames.hasNext()){
            String name = fileNames.next();
            MultipartFile file = request.getFile(name);
            String saveFilename = System.currentTimeMillis()+"-"+file.getOriginalFilename();
            File targetFile = new File(uploadPath + saveFilename);
            // 得到UpYun实例
            UpYun upYun = UpYunUtil.getUpYun();
            try{
                file.transferTo(targetFile);
                upYun .setContentMD5(UpYun.md5(targetFile));
                boolean result = upYun.writeFile(UpYunUtil.getUpYunFileSavePath(upYun) + saveFilename, targetFile, true);
                if(!result){
                    throw new ServiceException("文件写入云端出错");
                }
                FileUtils.deleteQuietly(targetFile);
            }catch (Exception e){
                throw new ServiceException("上传文件出错");
            }
            Map<String,Object> fileValue = new HashMap<>();
            fileValue.put("url", UpYunUtil.getUpYunFileFullPath(upYun, saveFilename));
            fileValue.put("thumbnailUrl", UpYunUtil.getUpYunThumbnailsPath(upYun, saveFilename));
            fileValue.put("name", file.getOriginalFilename());
            fileValue.put("type", file.getContentType());
            fileValue.put("size", file.getSize());
            fileValue.put("deleteUrl", "/web/upload/delete/" +saveFilename);
            fileValue.put("deleteType", "GET");
            files.add(fileValue);
        }
        Map<String,Object> filesReturn = new HashMap<>();
        filesReturn.put("files", files);
        return filesReturn;
    }

    public boolean deleteUpYunFileByFilePath(String filepath) {
        return false;
    }
}
