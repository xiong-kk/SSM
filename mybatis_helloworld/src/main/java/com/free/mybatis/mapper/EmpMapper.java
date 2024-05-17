package com.free.mybatis.mapper;

import com.free.mybatis.pojo.Dept;
import com.free.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author free
 * @create 2023-08-23-11:47
 */
public interface EmpMapper {
    /*
    * 根据员工id查询员工信息
    * */
    Emp getEmpByEmpId(@Param("empId") Integer empId);
    /*
    * 根据员工id查询员工及对应部门信息
    * */
    Emp getEmpAndDeptByEmpId(@Param("empId") Integer empId);
    /*
    分步根据员工id查询员工及对应部门信息，第一步
    * */
    Emp getEmpAndDeptByStepOne(@Param("empId") Integer empId);

    /*
     * 分步根据部门id查询部门信息及其下所有员工信息第二步
     * */
    Emp getDeptAndEmpByStepTwo(@Param("deptId") Integer deptId);

    /*
    * 根据动态条件查询员工信息
    * */
    List<Emp> getEmpByCondition(Emp emp);

    /*
     * 根据choose查询员工信息
     * */
    List<Emp> getEmpByChoose(Emp emp);

    /*
    * 批量添加员工
    * */
    void insertMoreEmp(@Param("emps") List<Emp> emps);

    /*
    * 批量删除员工
    * */
    void deleteMoreEmp(@Param("empIds") Integer[] empIds);
}
