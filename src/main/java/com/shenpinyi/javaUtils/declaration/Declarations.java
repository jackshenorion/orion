package com.shenpinyi.javaUtils.declaration;

/**
 * Created by jack on 26/04/2017.
 */
public class Declarations {

    public static void run() {
        Declarations d = new Declarations();
        Inner inner = d.new Inner(); //注意创建内部类的语法
        inner.run();
//        BaseIntf.a = 4; 接口中的变量是静态final的
    }

    class Inner {
        public void run() {
            System.out.println("Inner is running");
        }
    }

    abstract class Class2 implements BaseIntf {

        @Override
        public boolean m1() { // 注意,接口的实现类如果实现接口,必须是public, 因为interface中的接口就算没有修饰符,也是public
            return false;
        }

        // 抽象类不用实现接口类中的接口也可以通过编译
    }

    class SubClass extends BaseClass {
        @Override
        public void m1() {
            super.m1();
        }

        @Override
        protected void m2() {
            super.m2();
        }

//        @Override
//        private void m3() {   compile error
//            super.m3();
//        }

    }

}
