package com.swei.utils;

import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * Description: BeanCopy工具类
 *
 * @author: SweiPC
 * @data: 2022-08-24 16:06
 */
public class BeanCopyUtils {
    public BeanCopyUtils() {

    }

    /**
     * 对象的拷贝
     * @param source
     * @param clazz
     * @param <V>
     * @return
     */
    public static <V> V copyBean(Object source, Class<V> clazz) {
        // 创建目标对象
        V target = null;
        try {
            target = clazz.newInstance();
            // 实现属性的copy
            BeanUtils.copyProperties(source, target);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return target;
    }

    /**
     * 对象列表的拷贝
     * @param sources
     * @param clazz
     * @return
     */
    public static <V> List<V> copyBeanList(List<?> sources, Class<V> clazz) {
        return sources.stream()
                .map(o -> copyBean(o, clazz))
                .collect(Collectors.toList());

    }
}
