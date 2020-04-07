package com.seata.user.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yulong
 * @create 2020/3/27
 */
public class CustomerTest {

    public void  changeString (String str){
        str = "xxx";
        System.out.println("str: "+str);
    }

    public void  changeInt (int inti){
        inti = 200;

    }

    public static void main(String[] args) {
        testString();
        List<Object> list = Collections.synchronizedList(new ArrayList<>());
        Lock lock = new ReentrantLock();


        String aa = "123";
        new CustomerTest().changeString(aa);
        System.out.println("aa:"+aa);

        int aaa = 0;
        new CustomerTest().changeInt(aaa);
        System.out.println("aaaaa:"+aaa);
    }


    private static void testString() {
        String s = new String("abc");
        String s1 = "abc";
        String s2 = new String("abc");
        System.out.println(s == s1.intern());
        System.out.println(s == s2.intern());
        System.out.println(s1 == s2.intern());
    }
}
