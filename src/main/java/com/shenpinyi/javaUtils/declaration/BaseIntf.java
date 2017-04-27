package com.shenpinyi.javaUtils.declaration;

/**
 * Created by jack on 26/04/2017.
 */
public interface BaseIntf {
    boolean m1();
    byte m2(short s);
//    static boolean m3();  无法通过编译, 接口不支持定义静态方法。如果出现静态方法,必须有方法体
    static boolean m4() {return false;}

    int a = 2; //接口中也可以定义静态变量,但是要有初始值,因为这个值也是final的。
}
