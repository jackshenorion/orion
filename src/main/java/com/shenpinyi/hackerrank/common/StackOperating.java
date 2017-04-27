package com.shenpinyi.hackerrank.common;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by jack on 27/04/2017.
 */
public class StackOperating {
    /**
     * 这部分我们主要确定几个方面:
     * 1 Java中有没有比较好用的栈类 (回答: Java有Stack类可以直接使用,不一定非要用LinkedList)
     * 2 栈在栈数据为空的时候,会有什么行为 (回答: Stack为空的时候peek也会抛异常,不过LinkedList不会抛异常,而是返回空值)
     * 3 一般栈操作使用while操作需要注意什么 (回答: 1 注意要判断Stack是否为空 2 注意栈是LIFO的,所以要注意顺序)
     */

    public static void run() {
        /**
         * 这个样例使用栈来实现: 不断将字符串中连续两个相同的字符删除,输出最终剩余的部分
         */
        String s = "aa";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (!stack.empty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        if (stack.size() == 0) {
            System.out.println("Empty String");
        } else {
            /**
             * 最后的操作是将栈中的数据不断的倒出来,因为注意栈保存数据是LIFO的,所以需要相反方向填充数组
             */
            char[] output = new char[stack.size()];
            int i = stack.size() - 1;
            while (!stack.empty()) {
                output[i--] = stack.pop();
            }
            System.out.println(new String(output));
        }
    }

    public static void run1() {
        Stack<Integer> stack = new Stack();
        /**
         * 当栈位空的时候,使用peek会抛出EmptyStackException
         * 所以在使用栈的时候,需要使用size()或者empty()来判断是否为空
         */
        try {
            System.out.println(stack.peek());
        } catch (Exception e) {
            System.out.println("Caught exception: " + e.getClass().getName());
        }
        System.out.println(stack.empty());
        System.out.println(stack.size());
    }

    public static void run2() {
        LinkedList<Integer> stack = new LinkedList<>(); // 我们也可以使用LinkedList作为栈使用
        stack.addFirst(1); // 为了代码统一,我们统一将first作为栈顶,因此 stack.addFirst可以作为压栈操作
        stack.getFirst();  // 这个方法可以作为peek使用
        stack.removeFirst(); // 因为插入是在first进行,因此出栈也从first进行
        System.out.println(stack.peek()); // LinkedList如果为空,peek返回空值,这个和Stack类不同
//        System.out.println(stack.getFirst()); // 因为LinkedList是空的,所以抛出异常NoSuchElementException
//        System.out.println(stack.removeFirst()); // 同样也会抛出NoSuchElementException异常
    }

    public static void main(String args[]) {
        run2();
    }
}
