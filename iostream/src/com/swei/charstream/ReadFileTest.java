package com.swei.charstream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-12-19
 * Time: 22:04
 */
public class ReadFileTest {
    public static void main(String[] args) throws IOException {
        String filePath = "c:/test1.txt";
        FileReader fileReade = null;
        int fileLen = 0;
        char[] buf = new char[8];
        fileReade = new FileReader(filePath);
        while((fileLen = fileReade.read(buf)) != -1) {
            System.out.print(new String(buf,0,fileLen));
        }
        fileReade.close();
    }
    public static void main1(String[] args) throws IOException {
        String filePath = "c:/test1.txt";
        FileReader fileReade = null;
        int fileDate = 0;
        fileReade = new FileReader(filePath);
        while((fileDate = fileReade.read()) != -1) {
            System.out.print((char) fileDate);
        }
        fileReade.close();
    }
}