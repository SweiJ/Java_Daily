package com.swei.bytestream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-12-19
 * Time: 21:33
 */
public class FileCopyTest {
    public static void main1(String[] args) throws IOException {
        String srcPath = "c:/test1.txt";
        String DestPath = "d:/test1.txt";
        int fileLen = 0;
        FileInputStream fileInputStream = new FileInputStream(srcPath);
        FileOutputStream fileOutputStream = new FileOutputStream(DestPath);
        byte[] buf = new byte[1024];
        while((fileLen = fileInputStream.read(buf)) != -1){
            fileOutputStream.write(buf,0,fileLen);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
    public static void main(String[] args) throws IOException {
        String srcPath = "c:/test1.txt";
        String DestPath = "d:/test1.txt";
        int fileLen = 0;
        FileInputStream fileInputStream = new FileInputStream(srcPath);
        FileOutputStream fileOutputStream = new FileOutputStream(DestPath);
        byte[] buf = new byte[fileInputStream.available()];
        fileInputStream.read(buf);
        fileOutputStream.write(buf);
        fileInputStream.close();
        fileOutputStream.close();
    }
}
