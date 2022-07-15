package com.example.com.mybatisp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.com.mybatisp.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper

public interface UserMapper extends BaseMapper<User> {
}
