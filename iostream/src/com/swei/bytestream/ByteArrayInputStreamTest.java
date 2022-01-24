package com.swei.bytestream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-01-23
 * Time: 19:02
 */
public class ByteArrayInputStreamTest {
    public static void main(String[] args) {
        byte[] arr = "ancdefg".getBytes();
        ByteArrayInputStream bis = new ByteArrayInputStream(arr);
        StringBuilder sb = new StringBuilder();
        int temp = 0;
        while((temp = bis.read()) != -1) {
            sb.append((char)temp);
        }
        System.out.println(sb);
    }
    public static void ByteArrayOutputStreamTest(String[] args) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        StringBuilder sb = new StringBuilder();
        bos.write('a');
        bos.write('b');
        bos.write('c');
        byte[] arr = bos.toByteArray();
        for (int i = 0; i < arr.length; i++) {
            sb.append((char)arr[i]);
        }
        System.out.println(sb);
    }
}
