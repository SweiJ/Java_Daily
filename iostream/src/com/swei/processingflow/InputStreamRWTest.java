package com.swei.processingflow;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-01-23
 * Time: 16:46
 */
public class InputStreamRWTest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PrintWriter pw = new PrintWriter("d:/test.txt");

        String input = br.readLine();
        bw.write(input);

        pw.println(input);
        bw.close();
        pw.close();
        br.close();
    }

}
