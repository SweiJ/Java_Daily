package com.swei.processingflow;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-01-23
 * Time: 16:27
 */
public class FileCopy {
    public static void main(String[] args) throws IOException {
        String filePath1 = "c:/test1.txt";
        String filePath2 = "c:/test2.txt";
        BufferedReader br = new BufferedReader(new FileReader(filePath1));
        BufferedWriter bw = new BufferedWriter(new FileWriter(filePath2));
        String temp = "";

        while((temp = br.readLine()) != null) {
            bw.write(temp);
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
