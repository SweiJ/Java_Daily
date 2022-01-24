package com.swei.bytestream;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-01-23
 * Time: 15:35
 */
public class BufferedStreamTest {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            fis = new FileInputStream("c:/Test.txt");
            bis = new BufferedInputStream(fis);
            fos = new FileOutputStream("c:/Test1.txt");
            bos = new BufferedOutputStream(fos);

            // 缓冲流中byte数组长度默认为8192
            // private static int DEFAULT_BUFFER_SIZE = 8192;
            int temp = 0;
            while((temp = bis.read()) != -1) {
                bos.write(temp);
            }
            bos.flush();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(bos != null) {
                    bos.close();
                }
                if(fos != null) {
                    fos.close();
                }
                if(bis != null) {
                    bis.close();
                }
                if(fis != null) {
                    fis.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
