package com.hc.utils;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

    public static String now() {
        return null;
    }

    /**
     * 创建分页请求.
     */
    public static PageRequest buildPageRequest(Map pageParams) {
        int page = 1;
        int count = 1;
        Sort sort = null;

        for(Object key : pageParams.keySet()){
            String paramKey = (String)key;
            if (paramKey.equals("page")){
                page = Integer.valueOf((String)pageParams.get(paramKey));
            }
            if (paramKey.equals("count")){
                count = Integer.valueOf((String)pageParams.get(paramKey));
            }
            if (paramKey.startsWith("sorting[")){
                String sortKey = paramKey.substring(paramKey.indexOf("[")+1,paramKey.lastIndexOf("]"));
                String sortType = (String)pageParams.get(paramKey);
                if(sortType.equals("asc")){
                    sort = new Sort(Sort.Direction.ASC, sortKey);
                }
                if(sortType.equals("desc")){
                    sort = new Sort(Sort.Direction.DESC, sortKey);
                }
            }
        }
        return PageRequest.of(page-1, count, sort);
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
            if (((String) value).trim().replaceAll("\\s", "").equals("")) {
                return true;
            }
        } else if (value instanceof Collection) {
            if (((Collection) value).isEmpty()) {
                return true;
            }
        } else if (value.getClass().isArray()) {
            if (Array.getLength(value) == 0) {
                return true;
            }
        } else if (value instanceof Map) {
            if (((Map) value).isEmpty()) {
                return true;
            }
        } else {
            return false;
        }
        return false;

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
