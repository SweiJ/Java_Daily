package com.swei.serialization;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-12-20
 * Time: 10:41
 */
public class SerializationTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String filePath = "d:/test.txt";

        ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(filePath));
        ObjectInputStream oi = new ObjectInputStream(new FileInputStream(filePath));

        oo.writeObject(new JiaQi("小姜", 21));
        JiaQi j = (JiaQi) oi.readObject();
        System.out.println(j.toString());

        oo.close();
        oi.close();
    }
}
class JiaQi implements Serializable {
    private String name;
    private int age;

    public JiaQi(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "JiaQi{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
