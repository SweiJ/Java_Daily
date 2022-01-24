package com.swei.charstream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-01-23
 * Time: 16:10
 */
public class FileCopy {
    public static void main(String[] args) throws IOException {
        String filePath1 = "c:/test1.txt";
        String filePath2 = "c:/test2.txt";
        FileReader fr = new FileReader(filePath1);
        FileWriter fw = new FileWriter(filePath2);
        int fileDate = 0;
        char[] buf = new char[1024];
        while((fileDate = fr.read()) != -1) {
            fw.write(buf,0,fileDate);
        }
        fw.close();
        fr.close();
    }
}
