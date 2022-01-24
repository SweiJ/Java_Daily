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

        // �Ḳ��ԭ�����ļ�����
        fileOutputStream = new FileOutputStream(filePath);
        // ��׷�����ݵ��ļ�
        fileOutputStream = new FileOutputStream(filePath,true);
        for (char i = 'a'; i < 'z'; i++) {
            // ֻ��д��һ���ֽ�
            fileOutputStream.write(i);
        }
        // ���ַ���ת�����ֽ�����
        String str = "helloword";
        fileOutputStream.write(str.getBytes(StandardCharsets.UTF_8));
        // ���ַ���ת�����ַ����飬����ֻд��0��3���ַ�
        fileOutputStream.write(str.getBytes(),0,3);
        fileOutputStream.close();

    }
}
