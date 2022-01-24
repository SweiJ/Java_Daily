package com.swei.bytestream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-12-19
 * Time: 20:51
 */
public class InputStreamTest {
    /**
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        String filePath = "c:/Test.txt";
        int readLen = 0;
        byte[] buf = new byte[8];
        FileInputStream fileInputStream = null;

        fileInputStream = new FileInputStream(filePath);
        // 如果读取完毕，返回-1，如果读取正常，返回实际长度
        while ((readLen = fileInputStream.read(buf)) != -1) {
            System.out.print(new String(buf,0,readLen));
        }
        fileInputStream.close();
    }
    /**
     * 只读取单个字节，速率较慢
     * @param args
     * @throws IOException
     */
    public static void main1(String[] args) throws IOException {
        String filePath = "c:/Test.txt";
        int readDate = 0;
        FileInputStream fileInputStream = null;

        fileInputStream = new FileInputStream(filePath);
        while ((readDate = fileInputStream.read()) != -1) {
            // 只输出一个字节，如果文本里面是汉字(一个汉字3字节)，那么将输出错误
            System.out.print((char)readDate);
        }
        fileInputStream.close();
    }
}
