package com.xxx.server;

import com.xxx.server.mapper.AdminMapper;
import com.xxx.server.pojo.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-05-07
 * Time: 11:42
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MapperTest {
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void testAdminMapper() {
        List<Admin> admins = adminMapper.selectList(null);
        for (Admin admin : admins) {
            System.out.println(admin);
        }
    }

    @Test
    public void testpassword() {
        System.out.println(passwordEncoder.matches("123", "2312124"));
    }
}
