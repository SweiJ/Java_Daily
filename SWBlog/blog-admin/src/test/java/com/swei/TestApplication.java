package com.swei;

import com.swei.mapper.UserRoleMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: SweiPC
 * @data: 2022-08-30 9:29
 */
@SpringBootTest
public class TestApplication {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Test
    public void test() {
        List<String> ids = new ArrayList<>();
        ids.add("1");
        ids.add("2");
        int count = userRoleMapper.selectUserRoleByRoleIds(ids);
        System.out.println(count);

    }
}
