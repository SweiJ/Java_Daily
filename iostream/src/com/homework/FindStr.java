package com.homework;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-04-05
 * Time: 9:00
 */
public class FindStr {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要扫描的文件路径(绝对路径 or 相对路径)");
        String rootPath = sc.next();
        File rootDir = new File(rootPath);
        if(!rootDir.isDirectory()) {
            System.out.println("你输入的根目录不存在或者不是目录!");
            return;
        }
        System.out.println("请输入要找出的文件中的字符!");
        String str = sc.next();

        List<File> result = new ArrayList<>();
        scanDirwithContent(rootDir, str, result);
        System.out.println("查询有" + result.size() + "个文件包含字符串");

        for (File file : result) {
            System.out.println(file.getCanonicalFile());
        }
    }
    private static void scanDirwithContent(File rootDir, String str, List<File> result) throws IOException {
        File[] files = rootDir.listFiles();
        if(files == null && files.length == 0) {
            return;
        }
        for (File file : files) {
            if(file.isDirectory()) {
                scanDirwithContent(file, str, result);
            } else {
                if(fileContainsStr(file, str)) {
                    result.add(file.getCanonicalFile());
                }
            }
        }
    }

    private static boolean fileContainsStr(File file, String str) {
        StringBuilder stringBuilder = new StringBuilder();

        try (Reader reader = new FileReader(file)) {
            while(true) {
                char[] buf = new char[1024];
                int len = reader.read(buf);
                if(len == -1) {
                    break;
                }
                stringBuilder.append(buf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.indexOf(str) != -1;
    }
}
