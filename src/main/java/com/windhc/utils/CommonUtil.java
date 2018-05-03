package com.windhc.utils;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.lang.reflect.Array;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

/**
 * 通用工具类
 * @author Administrator
 * @date 2015/8/26
 */
public class CommonUtil {

    public static String getCurrentUserName() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        return userDetails.getUsername();
    }

    public static boolean isNotNull(Object value) {
        return !isNull(value);
    }

    /**
     * 可以用于判断Object,String,Map,Collection,String,Array是否为空
     */
    public static boolean isNull(Object value) {
        if (value == null) {
            return true;
        } else if (value instanceof String) {
            return ((String) value).trim().replaceAll("\\s", "").equals("");
        } else if (value instanceof Collection) {
            return ((Collection) value).isEmpty();
        } else if (value.getClass().isArray()) {
            return Array.getLength(value) == 0;
        } else if (value instanceof Map) {
            return ((Map) value).isEmpty();
        } else {
            return false;
        }
    }

    /**
     * 比较两个日期相差的秒数
     */
    public static long compareTime(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            return 0;
        }

        Calendar c = Calendar.getInstance();
        c.setTime(date1);
        long l1 = c.getTimeInMillis();
        c.setTime(date2);
        long l2 = c.getTimeInMillis();
        return (l2 - l1) / 1000;
    }
}
