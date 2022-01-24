package com.swei.bytestream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-12-19
 * Time: 21:18
 */
public class OutputStreamTest {
    public static void main(String[] args) throws IOException {
        String filePath = "c:/test1.txt";
        FileOutputStream fileOutputStream = null;

        // 会覆盖原来的文件内容
        fileOutputStream = new FileOutputStream(filePath);
        // 会追加内容到文件
        fileOutputStream = new FileOutputStream(filePath,true);
        for (char i = 'a'; i < 'z'; i++) {
            // 只能写入一个字节
            fileOutputStream.write(i);
        }
        // 将字符串转换成字节数组
        String str = "helloword";
        fileOutputStream.write(str.getBytes(StandardCharsets.UTF_8));
        // 将字符串转换成字符数组，并且只写入0到3个字符
        fileOutputStream.write(str.getBytes(),0,3);
        fileOutputStream.close();

    }
}
