package com.mybatisp.system.service.impl;

import com.mybatisp.system.entity.User;
import com.mybatisp.system.mapper.UserMapper;
import com.mybatisp.system.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xixi
 * @since 2022-07-10
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
