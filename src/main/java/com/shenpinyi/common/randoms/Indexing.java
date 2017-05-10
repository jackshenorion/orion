package com.shenpinyi.common.randoms;

import java.util.Random;

/**
 * Created by jack on 6/05/2017.
 */
public class Indexing {

    public static void main(String[] args) {

        /**
         * 如果要产生一个介于0和1之间的浮点数,那么就直接使用Math中的random方法
         */
        System.out.println(Math.random());

        /**
         * 上面还有一个办法就是用Random类的nextDouble方法。
         */
        Random rd = new Random();
        System.out.println(rd.nextDouble());

        /**
         * 如果要生成一个随机整数,没有范围,可以用Random类的nextInt方法
         */
        System.out.println(rd.nextInt());

        /**
         * 如果要生成一个比某个数小的正整数随机值
         */
        System.out.println(rd.nextInt(100));


    }

}
