package com.hc.service;

import org.springframework.web.multipart.MultipartRequest;

import java.util.Map;

/**
 * Created by Administrator on 2015/9/22.
 */
public interface FileStoreService {
    public Map<String, Object> saveFile(MultipartRequest request);
}
