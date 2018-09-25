package com.shenpinyi.lintcode.io;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void simpleCopyFiles() throws IOException {
        new Solution().simpleCopyFiles("C:\\Users\\jiashe\\Documents\\workspace\\orion\\src\\main\\java\\com\\shenpinyi\\lintcode\\io\\Solution.java",
                "C:\\Users\\jiashe\\Documents\\workspace\\orion\\src\\main\\java\\com\\shenpinyi\\lintcode\\io\\Solution.java.temp");

    }
}