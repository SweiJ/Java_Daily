package com.swei.serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-01-23
 * Time: 19:29
 */
public class ObjectOutputTest {
    public static void main(String[] args) throws IOException {
        String filePath = "c:/test1.txt";

        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(filePath));
        o.writeChar('a');
        o.writeBoolean(true);
        o.writeDouble(1.25);
        o.writeUTF("小姜超幸运！");
        o.writeObject(new JiaQi("小姜", 21));

        o.close();
    }
}
