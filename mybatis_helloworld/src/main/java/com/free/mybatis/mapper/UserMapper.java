package com.free.mybatis.mapper;

import com.free.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Property;

import java.util.List;
import java.util.Map;

/**
 * @author free
 * @create 2023-08-22-18:19
 */
public interface UserMapper {
    /*
    * 添加用户,并获取自增的主键
    * */
    int insertUser(User user);
    /*
    * 根据用户名查询用户信息
    * */
    User getUserByUsername(String username);

    /*
    * 根据用户名和密码查询用户信息
    * */
    User checkLogin(String username, String password);

    User checkLoginByMap(Map map);

    /*
    * 根据用户名模糊查询用户
    * */
    List<User> getUserByLike(String username);
    /*
    * 批量删除
    * */
    void deleteMoreUser(@Param("ids") String ids);
}
