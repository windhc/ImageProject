package com.windhc.config.upyun;

import main.java.com.UpYun;
import main.java.com.upyun.UpException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;

/**
 * @author Administrator
 * @date 2015/9/26
 */
public class UpYunService {

    private UpYunProperties properties;

    private UpYun upYun;

    public UpYunService(UpYunProperties properties) {
        this.properties = properties;

        this.upYun = new UpYun(properties.getBucketName(), properties.getUsername(), properties.getPassword());
        this.upYun.setDebug(properties.getDebug());
        this.upYun.setTimeout(properties.getTimeout());
        this.upYun.setApiDomain(properties.getApiDomain());
    }

    public Boolean upload(MultipartFile file, String filePath) {
        try {
            return upYun.writeFile(filePath, file.getBytes(), true);
        } catch (IOException | UpException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void deleteFile(String filePath) {
        try {
            this.upYun.deleteFile(filePath);
        } catch (IOException | UpException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 得到当前上传文件的保存路径，没有则按照年月创建
     *
     * @return 文件保存的路径
     */
    public String getUpYunFileSavePath() {
        LocalDate now = LocalDate.now();
        String path = "/" + now.getYear() + "/" + now.getMonthValue() + "/";
        // 创建目录，自动创建父级目录
        try {
            if (this.upYun.mkDir(path, true)) {
                return path;
            }
        } catch (IOException | UpException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    /**
     * 得到UPYUN上文件保存的全路径，包括域名及文件
     *
     * @return 文件保存的路径
     */
    public String getUpYunFileFullPath(String filename) {

        return "http://imagestore.b0.upaiyun.com" + getUpYunFileSavePath() + filename;
    }

    public String getUpYunThumbnailsPath(String filename) {

        return "http://imagestore.b0.upaiyun.com" + getUpYunFileSavePath() + filename + "!80x80";
    }
}
