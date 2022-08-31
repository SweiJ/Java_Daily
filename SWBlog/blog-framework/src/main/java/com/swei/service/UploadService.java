package com.swei.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.swei.utils.ResponseResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-08-27 21:02
 */
public interface UploadService {
    /**
     * 上传图片文件
     * @param img
     * @return
     */
    ResponseResult uploadImg(MultipartFile img);
}
