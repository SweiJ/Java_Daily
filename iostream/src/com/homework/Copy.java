package com.homework;

import java.io.*;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-04-05
 * Time: 8:47
 */
public class Copy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要复制的文件路径(绝对路径 or 相对路径)");
        String sourcePath = sc.next();
        File sourceFile = new File(sourcePath);
        if(!sourceFile.exists()) {
            System.out.println("文件不存在, 请确认路径是否正确!");
        }
        if(!sourceFile.isFile()) {
            System.out.println("不是普通文件, 请确认路径是否正确!");
        }
        System.out.println("请输入目标路径(绝对路径 or 相对路径)");
        String desPath = sc.next();
        File desFile = new File(desPath);
        if(desFile.exists()) {
            if(desFile.isDirectory()) {
                System.out.println("目标路径是个目录, 请确认路径是否正确!");
                return;
            }
            if(desFile.isFile()) {
                System.out.println("文件已经存在, 是否进行覆盖? y/n");
                String isCover = sc.next();
                if(!isCover.toLowerCase().equals("y")) {
                    System.out.println("停止复制");
                    return;
                }
            }
        }
        try (InputStream is = new FileInputStream(sourceFile)) {
            try (OutputStream os = new FileOutputStream(desFile)) {
                byte[] buf = new byte[1024];
                int len;

                while(true) {
                    len = is.read(buf);
                    if(len == -1) {
                        break;
                    }
                    os.write(buf, 0, len);
                }
                os.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("复制已完成!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
