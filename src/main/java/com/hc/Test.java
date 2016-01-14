package com.hc;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by Administrator on 2015/8/21.
 */
public class Test {

    public static void main(String[] args) {

        System.out.println(new BCryptPasswordEncoder().encode("123456"));
//        StringBuffer a = new StringBuffer("A");
//        StringBuffer b = new StringBuffer("B");
//        operator(a, b);
//        System.out.println(Long.MAX_VALUE);
//        System.out.println(new BCryptPasswordEncoder(4).encode("123456"));
//
//        List<Integer> integerList = new ArrayList<>();
//        integerList.add(1);
//        integerList.add(2);
//
//        //对每一个元素操作，然后通过collect返回一个新的list
//        integerList = integerList.stream().map(n ->
//                        n * 5
//        ).collect(Collectors.toList());
//
//        //遍历list
//        integerList.forEach(n ->
//                        System.out.println(n)
//        );
//
//        //筛选list
//        integerList.stream().filter(n ->
//                n%2 == 0
//        ).collect(Collectors.toList()).forEach(n->System.out.println(n));
//
//    }
//
//    public static void operator(StringBuffer x, StringBuffer y) {
//        x.append(y);
//        y = x;
    }
}
