package com.swei.serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-12-20
 * Time: 10:59
 */
public class DeserializeTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String filePath = "c:/test1.txt";

        ObjectInputStream o = new ObjectInputStream(new FileInputStream(filePath));

        // 读取(反序列化)的顺序需要和保存数据(序列化)顺序一致
        System.out.println(o.readChar());
        System.out.println(o.readBoolean());
        System.out.println(o.readDouble());
        System.out.println(o.readUTF());
        System.out.println(o.readObject());

        o.close();
    }
}
