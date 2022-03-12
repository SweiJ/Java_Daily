package org.example.service.Impl;

import org.example.service.NumService;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-03-12
 * Time: 17:45
 */
public class NumServiceImpl implements NumService {
    @Override
    public Integer doAdd(Integer a, Integer b, Integer c) {
        return a + b + c;
    }
}
