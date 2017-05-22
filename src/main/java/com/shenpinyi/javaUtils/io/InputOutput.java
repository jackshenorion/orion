package com.shenpinyi.javaUtils.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by jack on 26/04/2017.
 */
public class InputOutput {
    /**
     * 首先解决一个最简单的需求,如何将文本写入或者从文件读取数据
     */

    /**
     * 字节流
     * 如果你想一个字节一个字节地读写文件,那么就要用到FileInputStream和FileOutputStream
     * 每次调用read或者write都是返回输入一个int,如果read到文件末尾,那么就返回-1
     *
     * 字符流
     * FileReader和FileWriter
     * 和字节流类似,但是不同点就是以字符为单位读写文件。适用于不仅仅是ascii码的场景,比如unicode
     * 其它操作和字节流一样,都是以判断是否-1来判断是否到文件结尾
     *
     * 缓冲字节流
     * BufferedInputStream
     * BufferedOutputStream
     * 和字节流类似,唯一个的区别缓冲流操作的对象是不是单个字符,而是字节数组,这样一次可以读写多个字符批量处理。
     * 因为数组的长度是
     *
     */



    /**
     * first, how to write a list of numbers, and each number occupy one line
     */

    public static void writeFile(int[] a, String filePath) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(filePath);
            for (int n : a) {
                writer.write(n + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * second, how to read from txt file which has a list of numbers
     */
    public static List<Integer> readFile(String filePath) {
        List<Integer> a = new ArrayList<>();
        FileInputStream in = null;
        try {
            in = new FileInputStream(filePath);
            Scanner scanner = new Scanner(in);
            while (scanner.hasNext()) {
                a.add(scanner.nextInt());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return a;
        }
    }

    public static void checkIntList(List<Integer> a) {
        System.out.println("Length:" + a.size());
        for (int i = 0; i < Math.min(100, a.size()); i ++) {
            System.out.print(a.get(i) + ",");
        }
    }


    public static int[] createNumbers(int count) {
        Random r = new Random();
        int[] a = new int[count];
        for (int i = 0; i < count; i ++) {
            a[i] = r.nextInt();
        }
        return a;
    }

    public static void main(String[] args) {
        String path = "/Users/jack/temp/number1.txt";
        writeFile(createNumbers(1000), path);
        checkIntList(readFile(path));
    }

}
