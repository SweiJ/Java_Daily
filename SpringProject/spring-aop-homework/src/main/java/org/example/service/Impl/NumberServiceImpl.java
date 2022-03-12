package org.example.service.Impl;

import org.example.service.NumberService;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-03-12
 * Time: 16:34
 */
public class NumberServiceImpl implements NumberService {
    @Override
    public Integer addNum(Integer a, Integer b, Integer c) {
        return a + b + c;
    }
}
