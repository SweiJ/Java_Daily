package com.swei.utils;

import cn.hutool.core.util.IdUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExcelUtil {
    /**
     * 导出excel
     *
     * @param list      导出数据集合
     * @param sheetName 工作表的名称
     * @return 结果
     */
    public static <T> void exportExcel(List<T> list, String sheetName, Class<T> clazz, HttpServletResponse response) {
        try {
            String filename = encodingFilename(sheetName);
            response.reset();
            FileUtils.setAttachmentResponseHeader(response, filename);
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=UTF-8");
            ServletOutputStream os = response.getOutputStream();
            EasyExcel.write(os, clazz)
                .autoCloseStream(false)
                // 自动适配
                .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy())
                // 大数值自动转换 防止失真
                .registerConverter(new ExcelBigNumberConvert())
                .sheet(sheetName).doWrite(list);
        } catch (IOException e) {
            throw new RuntimeException("导出Excel异常");
        }
    }
    /**
     * 编码文件名
     */
    public static String encodingFilename(String filename) {
        return IdUtil.fastSimpleUUID() + "_" + filename + ".xlsx";
    }

}