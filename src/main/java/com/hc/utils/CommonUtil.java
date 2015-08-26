package com.hc.utils;

import java.lang.reflect.Array;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

/**
 * 通用工具类
 * Created by Administrator on 2015/8/26.
 */
public class CommonUtil {

    public static boolean isNotNull(Object value){

        return !isNull(value);
    }

    /** 可以用于判断Object,String,Map,Collection,String,Array是否为空 */
    public static boolean isNull(Object value) {
        if (value == null) {
            return true;
        } else if(value instanceof String){
            if(((String)value).trim().replaceAll("\\s", "").equals("")){
                return true;
            }
        }else if(value instanceof Collection) {
            if(((Collection)value).isEmpty()){
                return true;
            }
        } else if(value.getClass().isArray()) {
            if(Array.getLength(value) == 0){
                return true;
            }
        } else if(value instanceof Map) {
            if(((Map)value).isEmpty()){
                return true;
            }
        }else {
            return false;
        }
        return false;

    }

    /** 比较两个日期相差的秒数 */
    public static long compareTime(Date date1, Date date2) {
        if (date1 == null || date2 == null)
            return 0;

        Calendar c = Calendar.getInstance();

        c.setTime(date1);
        long l1 = c.getTimeInMillis();

        c.setTime(date2);
        long l2 = c.getTimeInMillis();

        return (l2 - l1) / 1000;
    }
}
