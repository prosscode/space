package com.space.utils;


import java.io.File;
import java.io.FileOutputStream;

/**
 * @describe: 文件处理类
 * @author: 吕涛pross
 * @date: 2019/02/19
 */
public class FileUtil {
    /**文件上传*/
    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath + fileName);
        out.write(file);
        out.flush();
        out.close();
    }
}
