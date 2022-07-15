package com.example.mybatisp;

import com.example.com.mybatisp.mapper.UserMapper;
import com.example.com.mybatisp.pojo.User;
import com.example.com.mybatisp.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class MybatisPlusTset1 {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
        List<User> users = userMapper.selectList(null);
        users.forEach(user -> System.out.println(user));
    }

    @Test
    void test2() {
        ArrayList<User> users = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setName("ybc" + i);
            user.setAge(20 + i);
            users.add(user);
    }

userService.saveBatch(users);
    }


    @Test
    void test3() {
        boolean b = userService.removeById(1L);
    }


}
