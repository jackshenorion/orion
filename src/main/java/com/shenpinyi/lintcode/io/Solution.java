package com.shenpinyi.lintcode.io;

import java.io.*;

public class Solution {

    public void simpleCopyFiles(String source, String target) throws IOException {
        InputStream is = new FileInputStream(source);
        is = new BufferedInputStream(is);
        OutputStream os = new BufferedOutputStream(new FileOutputStream(target));
        int b;
        while ((b = is.read()) != -1) {
            os.write(b);
        }
        is.close();
        os.close();
    }
}
