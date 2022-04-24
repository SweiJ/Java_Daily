package com.swei.summitexam.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-04-24
 * Time: 17:51
 */
@RequestMapping("/paper-exam")
@RestController
public class examController {

    @RequestMapping("/add")
    public Map<String, Object> add(String name, String score, String selectId) {
        Map<String, Object> map = new HashMap<>();

        return null;
    }
}
