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
        // �����ȡ��ϣ�����-1�������ȡ����������ʵ�ʳ���
        while ((readLen = fileInputStream.read(buf)) != -1) {
            System.out.print(new String(buf,0,readLen));
        }
        fileInputStream.close();
    }
    /**
     * ֻ��ȡ�����ֽڣ����ʽ���
     * @param args
     * @throws IOException
     */
    public static void main1(String[] args) throws IOException {
        String filePath = "c:/Test.txt";
        int readDate = 0;
        FileInputStream fileInputStream = null;

        fileInputStream = new FileInputStream(filePath);
        while ((readDate = fileInputStream.read()) != -1) {
            // ֻ���һ���ֽڣ�����ı������Ǻ���(һ������3�ֽ�)����ô���������
            System.out.print((char)readDate);
        }
        fileInputStream.close();
    }
}
