package com.hc;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by Administrator on 2015/8/21.
 */
public class Test {
    public static void main(String[] args) {
        StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("B");
        operator(a, b);
        System.out.println(new BCryptPasswordEncoder(4).encode("123456"));
    }
    public static void operator(StringBuffer x, StringBuffer y) {
        x.append(y);
        y = x;
    }
}
