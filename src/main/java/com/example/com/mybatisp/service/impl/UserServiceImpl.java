package com.example.com.mybatisp.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.com.mybatisp.mapper.UserMapper;
import com.example.com.mybatisp.pojo.User;
import com.example.com.mybatisp.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
