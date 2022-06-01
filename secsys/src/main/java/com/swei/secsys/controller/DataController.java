package com.swei.secsys.controller;

import com.swei.secsys.pojo.Data;
import com.swei.secsys.pojo.Res;
import com.swei.secsys.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-06-01
 * Time: 15:10
 */
@RestController
@RequestMapping("/sec")
public class DataController {

    @Autowired
    private DataService dataService;

    @DeleteMapping("/user")
    public Res deleteUser() {
        return dataService.deleteUser();
    }
}
