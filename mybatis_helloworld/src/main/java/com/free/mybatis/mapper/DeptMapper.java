package com.free.mybatis.mapper;

import com.free.mybatis.pojo.Dept;
import com.free.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

/**
 * @author free
 * @create 2023-08-23-15:40
 */
public interface DeptMapper {
    /*
    分步根据员工id查询员工及对应部门信息，第二步
    * */
    Dept getEmpAndDeptByStepTwo(@Param("deptId") Integer deptId);

    /*
    * 根据部门id查询部门信息以及其下的所有员工信息
    * */
    Dept getDeptAndEmpByDeptId(@Param("deptId") Integer deptId);

    /*
    * 分步根据部门id查询部门信息及其下所有员工信息第一步
    * */
    Dept getDeptAndEmpByStepOne(@Param("deptId") Integer deptId);
}
