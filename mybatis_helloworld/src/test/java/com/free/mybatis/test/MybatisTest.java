package com.free.mybatis.test;

import com.free.mybatis.mapper.DeptMapper;
import com.free.mybatis.mapper.Emp3Mapper;
import com.free.mybatis.mapper.EmpMapper;
import com.free.mybatis.mapper.UserMapper;
import com.free.mybatis.pojo.Dept;
import com.free.mybatis.pojo.Emp;
import com.free.mybatis.pojo.Emp3;
import com.free.mybatis.pojo.User;
import com.free.mybatis.utils.SqlSessionUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

/**
 * @author free
 * @create 2023-08-22-18:29
 */
public class MybatisTest {


    @Test
    public void testInsertUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user=new User(null,"h2","123",18,"男","1@qq.com");
        int a=mapper.insertUser(user);
        System.out.println(user);
    }

    @Test
    public void testGetUserByUsername(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user=mapper.getUserByUsername("root");
        System.out.println(user);
    }

    @Test
    public void testCheckLogin(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user=mapper.checkLogin("root","123456");
        System.out.println(user);
    }

    @Test
    public void testGetUserByLike(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users=mapper.getUserByLike("admin");
        users.forEach(System.out::println);
    }

    @Test
    public void testDeleteMoreUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteMoreUser("5,6");
    }

    @Test
    public void testGetEmpByEmpId(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp=mapper.getEmpByEmpId(1);
        System.out.println(emp);
    }

    @Test
    public void testGetEmpAndDeptByEmpId(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp=mapper.getEmpAndDeptByEmpId(1);
        System.out.println(emp);
    }

    @Test
    public void testGetEmpAndDeptByStep(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp=mapper.getEmpAndDeptByStepOne(2);
        System.out.println(emp.getEmpName());
    }

    @Test
    public void testGetEmpAndDeptByStepTwo(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept=mapper.getEmpAndDeptByStepTwo(2);
        System.out.println(dept);
    }

    @Test
    public void testGetDeptAndEmpByDeptId(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept=mapper.getDeptAndEmpByDeptId(1);
        System.out.println(dept);
    }

    @Test
    public void testGetDeptAndEmpByStep(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept=mapper.getDeptAndEmpByStepOne(1);
        System.out.println(dept);
    }

    @Test
    public void testGetEmpByCondition(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp=new Emp(null,"张三",20,"男");
        List<Emp> res=mapper.getEmpByCondition(emp);
        res.forEach(System.out::println);
    }

    @Test
    public void testGetEmpByChoose(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp=new Emp(null,"张三",20,"男");
        List<Emp> res=mapper.getEmpByChoose(emp);
        res.forEach(System.out::println);
    }

    @Test
    public void testInsertMoreEmp(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp1=new Emp(null,"张三1",20,"男");
        Emp emp2=new Emp(null,"张三2",20,"男");
        Emp emp3=new Emp(null,"张三3",20,"男");
        List<Emp> emps = Arrays.asList(emp1, emp2, emp3);
        mapper.insertMoreEmp(emps);

    }

    @Test
    public void testDeleteMoreEmp(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Integer[] empIds=new Integer[]{5,6,7};

        mapper.deleteMoreEmp(empIds);

    }

    @Test
    public void testCache() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession1=sqlSessionFactory.openSession(true);
        EmpMapper mapper1= sqlSession1.getMapper(EmpMapper.class);
        Emp emp1=mapper1.getEmpByEmpId(1);
        System.out.println(emp1);
        sqlSession1.close();
        SqlSession sqlSession2=sqlSessionFactory.openSession(true);
        EmpMapper mapper2= sqlSession2.getMapper(EmpMapper.class);
        Emp emp2=mapper2.getEmpByEmpId(1);
        System.out.println(emp2);

    }

    @Test
    public void testPage() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession1=sqlSessionFactory.openSession(true);
        Emp3Mapper mapper= sqlSession1.getMapper(Emp3Mapper.class);
        //查询功能之前开启分页功能
        Page<Object> page = PageHelper.startPage(2, 2);
        List<Emp3> list = mapper.selectByExample(null);
        PageInfo<Emp> pageInfo=new PageInfo(list,5);

        list.forEach(System.out::println);
        System.out.println(pageInfo);
    }
}
