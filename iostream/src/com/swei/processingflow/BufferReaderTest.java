package com.swei.processingflow;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-12-20
 * Time: 9:46
 */
public class BufferReaderTest {
    public static void main(String[] args) throws IOException {
        String filePath = "C:\\Users\\SweiJ\\Desktop\\Java\\JavaGit\\iostream\\src\\IoTest.java";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));

        String str;
        while((str = bufferedReader.readLine()) != null) {
            System.out.println(str);
        }

        bufferedReader.close();
    }
}
