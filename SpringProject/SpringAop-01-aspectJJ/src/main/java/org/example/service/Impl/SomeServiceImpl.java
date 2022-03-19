package org.example.service.Impl;

import org.example.service.SomeService;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-03-12
 * Time: 9:22
 */

public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome() {
        System.out.println("SomeServiceImpl.doSome");
    }

    @Override
    public String doOther(String name, int age) {
        System.out.println("SomeServiceImpl.doOther");
        return "abc";
    }

    @Override
    public String doFirst(String name) {
        System.out.println("SomeServiceImpl.doFirst" + name);
        return name;
    }

    @Override
    public void doSecond(String name) {
        System.out.println("SomeServiceImpl.doSecond" + (10/0));
    }

    @Override
    public void doThird(String name) {
        System.out.println("SomeServiceImpl.doThird");
    }
}

