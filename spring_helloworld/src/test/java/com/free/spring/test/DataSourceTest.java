package com.free.spring.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.free.spring.controller.BookController;
import com.free.spring.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;
import java.util.List;

/**
 * @author free
 * @create 2023-06-08-10:03
 */
//指定当前测试类在spring的测试环境中执行，此时就可以通过注入的方式直接获取ioc容器中bean
@RunWith(SpringJUnit4ClassRunner.class)
//设置spring测试环境的配置文件
@ContextConfiguration(value = {"classpath:applicationContext.xml","classpath:spring-datasource.xml"})
public class DataSourceTest {
    @Autowired
    private BookController bookController;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testDataSource() throws SQLException{
        ApplicationContext ioc=new ClassPathXmlApplicationContext("spring-datasource.xml");
        DruidDataSource dataSource=ioc.getBean(DruidDataSource.class);
        System.out.println(dataSource.getConnection());
    }

    @Test
    public void testInsert(){
        String sql="insert into t_user values(null,?,?,?,?,?)";

        jdbcTemplate.update(sql,"root","123",24,"女","123@qq.com");
    }

    @Test
    public void testGetUserById(){
        String sql="select * from t_user where id=?";
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class),1);
        System.out.println(user);
    }

    @Test
    public void testGetAllUser(){
        String sql="select * from t_user";
        List<User> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        list.forEach(System.out::println);
    }

    @Test
    public void testGetCount(){
        String sql="select count(*) from t_user";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(count);
    }

    @Test
    public void testBuyBook(){
        bookController.buyBook(1,1);
    }
}
