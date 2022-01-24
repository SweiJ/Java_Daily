package com.swei.processingflow;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-12-20
 * Time: 9:50
 */
public class BufferWriterTest {
    public static void main(String[] args) throws IOException {
        String filePath = "c:/test1.txt";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));
        bufferedWriter.write("hello,小姜\n");
        bufferedWriter.write("hello,小姜\n");

        bufferedWriter.close();
    }
}
