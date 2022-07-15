package com.example.mybatisp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.example.com.mybatisp.mapper.ProductMapper;
import com.example.com.mybatisp.mapper.UserMapper;
import com.example.com.mybatisp.pojo.Product;
import com.example.com.mybatisp.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Wrapper;
import java.util.Collections;
import java.util.List;

@SpringBootTest
class MybatisPlusWrapper {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ProductMapper productMapper;

    @Test
    void contextLoads() {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.like("name","a")
                .between("age",20,30)
                .isNotNull("email");
        List<User> users = userMapper.selectList(userQueryWrapper);
        users.forEach(System.out::println);

    }

    @Test
    void queryWrapper1() {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.orderByDesc("age").orderByAsc("id");
        List<User> users = userMapper.selectList(userQueryWrapper);
    }

    @Test
    void queryWrapper2() {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.isNull("email");
        int delete = userMapper.delete(userQueryWrapper);

    }

    @Test
    void queryWrapper3() {
        Product product = productMapper.selectById(1);
        System.out.println(product.getPrice());
        Product product1 = productMapper.selectById(1);
        System.out.println(product.getPrice());
        product.setPrice(product.getPrice()+50);
        productMapper.updateById(product);
        product1.setPrice(product1.getPrice()-30);
        productMapper.updateById(product1);
        Product product2 = productMapper.selectById(1);
        System.out.println(product2.getPrice());

    }

    @Test
    void test4(){
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/mybatis_plus?serverTimezone=UTC", "root", "root")
                .globalConfig(builder -> {
                    builder.author("xixi") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("D:\\资料"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.mybatisp") // 设置父包名
                            .moduleName("system") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "D:\\资料")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("user") // 设置需要生成的表名
                            .addTablePrefix(); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }

}
