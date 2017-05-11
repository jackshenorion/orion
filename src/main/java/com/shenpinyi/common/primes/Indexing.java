package com.shenpinyi.common.primes;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jack on 11/05/2017.
 */
public class Indexing {


    /**
     * 关键点:
     * 1 判断一个数是否是素数(isPrime)
     * 2 基于isPrime,不断判断下一个数,支持(getNextPrime)
     * 这两个方法是最管用的方法。
     *
     * 尽量不用Sieve of Eratosthenes,空间占用太大了。
     */

    /**
     * Problem:
     * 1 判断n是否是prime number
     * 2 找出不大于n的prime numbers
     * 3 找出不大于n的最大的一个prime number
     * 4 将一个数分解成为一组prime numbers的乘积
     *
     *
     * 为了解决上面的问题,基于以下几个prime数的性质:
     * 性质1 任何一个数都可以分解为prime数的乘积
     * 性质2 2是prime number, 1既不是prime,也不是合数
     * 性质3 除了2以外的2的倍数都不是prime
     */

    /**
     * Problem1: 检查一个数是否是prime number(假设都是正整数):
     * 1 看看它是否是2,如果是那么就是true
     * 2 然后看看是否可以被2整除,如果能,那么就是false
     * 3 再取一个数k, 从3开始测试,每次加2,这样k就是奇数,看看是否能够整除n:
     *  a 整除的意思是n % k == 0
     *  b k向上只需要到Math.sqrt(n)就可以了,注意sqrt的结果是double,需要转型到int,(int) Math.sqrt(n)
     *
     * 这个算法的时间复杂度是O(sqrt(n))
     */
    public static boolean isPrimeNumber(int n) {
        if (n == 1) {
            return false;
        }

        if (n == 2) {
            return true;
        }

        if ((n & 1) == 0) {
            return false;
        }

        for (int i = 3; i <= (int) Math.sqrt(n); i += 2) { // 注意,这里是<=,而不是<
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }


    /**
     * Problem2: 找出n的下一个prime,或者n的前一个prime
     *
     * 方法1: 我们可以对从prime开始递减n,然后执行判断isPrimeNumber。这个的算法复杂度上界O(n*sqrt(n))
     * 方法2: 我们可以列出比n小的所有primes,用臭名昭著的Sieve of Eratosthenes这个算法复杂度基本上接近O(n2),空间复杂度要用到O(n),如果一个大数,那么空间需要会很大。
     *
     * 通常在解题中,建议还是使用方法1,从prime开始逐步递增,然后判断是否是prime number直到找到为止
     */

    public static int getNexPrimeNumber(int n) {
        int k = n + 1;
        while (!isPrimeNumber(k)){
            k++;
        }
        return k;
    }

    /**
     * Problem3: 找出不大于n的所有prime
     * 方法1: 使用getNextPrimeNumber不断的找下一个,直到找到的下一个PrimeNumber比n大为止 (这个算法复杂度事实上还行O(n*sqrt(n))),因为没有做很多重复的工作。
     * 方法2: 使用臭名昭著的Sieve of Eratosthenes,虽然事实上如果它经过各种优化,时间复杂度会比较低,但空间复杂度是O(N)。除非你能确定,这个数不太大,否则尽可能不要用它,因为它很可能会被认为是Naive的解法
     *
     * 方法1的使用见下面的Problem4
     */
    /**
     * Problem4: 把任何一个数分解成素数的乘积
     */
    public static Map<Integer, Integer> getPrimesForNumber(int n) {
        Map<Integer, Integer> primes = new HashMap<>();
        int prime = 2;
        while (prime <= n) {
            int exp = getExp(n, prime);
            if (exp != 0) {
                primes.put(prime, exp);
            }
            prime = getNexPrimeNumber(prime);
        }
        return primes;
    }

    private static int getExp(int n, int prime) {
        int exp = 0;
        while (n % prime == 0 && n != 0) {
            n = n / prime;
            exp ++;
        }
        return exp;
    }


    public static void main(String[] args) {

        System.out.println(getPrimesForNumber(109));
    }

}
