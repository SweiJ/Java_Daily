package com.swei;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiJ
 * Date: 2021-12-22
 * Time: 20:25
 */
public class DeleteDirectoryTest {
    public static void main(String[] args) {
        String Path = "c:" + File.separator + "test";
        recursiveDelete(new File(Path));

    }
    public static void recursiveDelete(File file) {
         if(!file.exists()) {
             return;
         }
         if(file.isDirectory()) {
             for (File f : file.listFiles()) {
                 recursiveDelete(f);
             }
         }
        file.delete();
        System.out.println("Deleted file/folder: "+file.getAbsolutePath());
    }
}
