package com.windhc.service;

import com.windhc.config.exception.ServiceException;
import com.windhc.config.upyun.UpYunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import java.util.*;

/**
 * @author Administrator
 * @date 2015/9/22
 */
@Service
public class FileStoreService {

    @Autowired
    private UpYunService upYunService;

    public Map<String, Object> saveFile(MultipartRequest request) {
        String uploadPath = this.getClass().getClassLoader().getResource("static/upload/").getPath();

        List<Map> files = new ArrayList<>();
        Iterator<String> fileNames = request.getFileNames();
        while (fileNames.hasNext()){
            String name = fileNames.next();
            MultipartFile file = request.getFile(name);
            String saveFilename = System.currentTimeMillis()+"-"+file.getOriginalFilename();

            boolean result = upYunService.upload(file, upYunService.getUpYunFileSavePath() + saveFilename);
            if(!result){
                throw new ServiceException("文件写入云端出错");
            }

            Map<String,Object> fileValue = new HashMap<>();
            fileValue.put("url", upYunService.getUpYunFileFullPath(saveFilename));
            fileValue.put("thumbnailUrl", upYunService.getUpYunThumbnailsPath(saveFilename));
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
