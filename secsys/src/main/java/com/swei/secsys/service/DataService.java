package com.swei.secsys.service;

import com.swei.secsys.pojo.Data;
import com.swei.secsys.pojo.Res;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-06-01
 * Time: 15:30
 */
public interface DataService {
    Res addUser(Data data);

    Res deleteUser();
}
