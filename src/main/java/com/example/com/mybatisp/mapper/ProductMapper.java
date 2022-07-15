package com.example.com.mybatisp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.com.mybatisp.pojo.Product;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper extends BaseMapper<Product> {
}
