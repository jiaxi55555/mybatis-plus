package com.example.mybatisp;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.com.mybatisp.mapper.UserMapper;
import com.example.com.mybatisp.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MybatisPlusConfig {
@Autowired
private UserMapper userMapper;


    @Test
    void contextLoads() {
        Page<User> page = new Page<>(1,3);
        System.out.println("1");
        System.out.println("2");
        System.out.println("master finally");
       userMapper.selectPage(page,null);
        System.out.println(page);
    }

}
