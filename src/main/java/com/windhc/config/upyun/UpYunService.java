package com.windhc.config.upyun;

import main.java.com.UpYun;
import main.java.com.upyun.UpException;

import java.io.IOException;
import java.util.Calendar;

/**
 * @author Administrator
 * @date 2015/9/26
 */
public class UpYunService {

//    private static UpYun UPYUN = new UpYun("imagestore", "imageuser", "123456hcd");

    /**
     * 得到UpYun实例
     * @return UpYun
     */
    public static UpYun getUpYun(){
        UpYun upYun = new UpYun("imagestore", "imageuser", "xxxx");
        upYun.setDebug(true);
        upYun.setTimeout(30);
        upYun.setApiDomain(UpYun.ED_AUTO);
        return upYun;
    }

    /**
     * 得到当前上传文件的保存路径，没有则按照年月创建
     * @return 文件保存的路径
     */
    public static String getUpYunFileSavePath(UpYun upYun){
        Calendar now = Calendar.getInstance();
        String path = "/"+now.get(Calendar.YEAR)+"/"+(now.get(Calendar.MONTH)+1)+"/";
        // 创建目录，自动创建父级目录
        try {
            if(upYun.mkDir(path, true)){
                return path;
            }
        } catch (IOException | UpException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 得到UPYUN上文件保存的全路径，包括域名及文件
     * @return 文件保存的路径
     */
    public static String getUpYunFileFullPath(UpYun upYun, String filename){

        return "http://imagestore.b0.upaiyun.com"+getUpYunFileSavePath(upYun)+filename;
    }

    public static String getUpYunThumbnailsPath(UpYun upYun, String filename){

        return "http://imagestore.b0.upaiyun.com"+getUpYunFileSavePath(upYun)+filename+"!80x80";
    }
}
