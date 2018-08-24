package com.shenpinyi.other.updateArray;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void updateArray() {

        String[][] a = new String[][]{
                {"a", "b", "c"},
                {"d", "e", "f"},
                {"g", "h", "i"}
        };
        String[][] b = new String[][]{
                {"d", "e", "y"},
                {"a", "b", "x"},
                {"g", "h", "i"}
        };
        new Solution().updateArray(a, b);
        assertArrayEquals(
                new String[][]{
                        {"a", "b", "x"},
                        {"d", "e", "y"},
                        {"g", "h", "i"}},
                a);
    }

    @Test
    public void pick() {

        Map<String, Map<String, String>> result = new Solution().pick(new HashMap<String, Map<String, String>>() {
            {
                put("0002", new HashMap<String, String>() {{
                    put("sid", "123456789");
                    put("name", "jack");
                }});
                put("0003", new HashMap<String, String>() {{
                    put("dis", "123456788");
                    put("name", "jack");
                }});
                put("0004", new HashMap<String, String>() {{
                    put("sid", "222222222");
                    put("name", "jack");
                }});
                put("0005", new HashMap<String, String>() {{
                    put("sid", "123456789");
                    put("name", "jack");
                }});
            }
        }, new String[]{"222222222"});
        System.out.println(result);
    }
}