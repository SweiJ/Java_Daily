package com.homework;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-04-04
 * Time: 19:12
 */
public class Del {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要扫描的根目录(绝对路径 or 相对路径)");
        String DirPath = sc.next();
        File file = new File(DirPath);
        if(!file.isDirectory()) {
            System.out.println("你输入的根目录不存在或不是目录, 退出!");
            return;
        }
        System.out.println("请输入要查找的字符: ");
        String str = sc.next();
        List<File> result = new ArrayList<>();
        scanDir(file, str, result);
        System.out.println("一共有" + result.size() + "个文件符合条件");

        for (File file1 : result) {
            System.out.println(file.getCanonicalFile() + "请问是否删除该文件!");
            String in = sc.next();
            if(in.toLowerCase().equals("y")) {
                file.delete();
            }
        }
    }
    private static void scanDir(File rootDir, String str, List<File> result) {
        File[] files = rootDir.listFiles();
        if(files == null || files.length == 0) {
            return;
        }

        for (File file : files) {
            // 如果当前文件的是目录的话继续搜索
            if(file.isDirectory()) {
                scanDir(file, str, result);
            } else {
                // 如果名称中包含字符str 则添加绝对路径到result
                if(file.getName().contains(str)) {
                    result.add(file.getAbsoluteFile());
                }
            }
        }
    }
}
