package com.swei.charstream;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-12-20
 * Time: 8:27
 */
public class WriterFileTest {
    public static void main(String[] args) throws IOException {
        String filePath = "c:/note.txt";
        FileWriter fileWriter = null;

        fileWriter = new FileWriter(filePath);
        fileWriter.write("h");
        char[] buf = {'1','2','3','4'};
        fileWriter.write(buf);
        String str = "小姜~超幸运，爱学习";
        fileWriter.write(str);
        fileWriter.write(str,0,6);

        fileWriter.close();
    }
}
