package com.hc.service;

import org.springframework.web.multipart.MultipartRequest;

import java.util.Map;

/**
 * @author Administrator
 * @date 2015/9/22
 */
public interface FileStoreService {

    /**
     * 保存上传的文件到又拍云
     * @param request 上传文件的请求
     * @return 上传结果
     */
    Map<String, Object> saveFile(MultipartRequest request);

    /**
     * 通过又拍云上的保存路径，删除云上的文件
     * @param filepath 保存路径
     * @return 删除的结果,布尔值
     */
    boolean deleteUpYunFileByFilePath(String filepath);

}
