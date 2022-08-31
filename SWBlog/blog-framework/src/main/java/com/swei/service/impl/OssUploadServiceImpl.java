package com.swei.service.impl;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.swei.SystemException;
import com.swei.service.UploadService;
import com.swei.utils.PathUtils;
import com.swei.utils.ResponseResult;
import com.swei.utils.enums.HttpCodeEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-08-27 21:08
 */
@Service
public class OssUploadServiceImpl implements UploadService {

    @Value("${oss.accessKey}")
    private String accessKey;

    @Value("${oss.secretKey}")
    private String secretKey;

    @Value("${oss.bucket}")
    private String bucket;

    @Value("${oss.domain}")
    private String domain;

    public String uploadOss(MultipartFile imgFile, String filePath) {
        //构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(Region.autoRegion());
        //...其他参数参考类注释

        UploadManager uploadManager = new UploadManager(cfg);

        //默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = filePath;

        try {
//            byte[] uploadBytes = "hello qiniu cloud".getBytes("utf-8");
//            ByteArrayInputStream byteInputStream=new ByteArrayInputStream(uploadBytes);

            InputStream inputStream = imgFile.getInputStream();
//            InputStream inputStream = new FileInputStream("C:\\Users\\root\\Desktop\\Snipaste_2022-02-28_22-48-37.png");
            Auth auth = Auth.create(accessKey, secretKey);
            String upToken = auth.uploadToken(bucket);

            try {
                Response response = uploadManager.put(inputStream,key,upToken,null, null);
                //解析上传成功的结果
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
                System.out.println(putRet.key);
                System.out.println(putRet.hash);
                return domain + key;
            } catch (QiniuException ex) {
                Response r = ex.response;
                System.err.println(r.toString());
                try {
                    System.err.println(r.bodyString());
                } catch (QiniuException ex2) {
                    //ignore
                }
            }
        } catch (Exception ex) {
            //ignore
        }
        return "www";
    }

    @Override
    public ResponseResult uploadImg(MultipartFile img) {
        // 判断文件类型
        // 获取原始文件名称
        String filename = img.getOriginalFilename();
        // 对原始文件名进行判断
        if(!filename.endsWith(".png")) {
            throw new SystemException(HttpCodeEnum.FILE_TYPE_ERROR);
        }

        String filePath = PathUtils.generateFilePath(filename);
        String url = uploadOss(img, filePath);
        return ResponseResult.okResult(url);
    }
}
