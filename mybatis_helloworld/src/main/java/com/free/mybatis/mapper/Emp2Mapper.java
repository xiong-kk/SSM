package com.free.mybatis.mapper;

import com.free.mybatis.pojo.Emp2;
import java.util.List;

public interface Emp2Mapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_emp
     *
     * @mbggenerated Wed Aug 23 23:20:57 CST 2023
     */
    int deleteByPrimaryKey(Integer empId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_emp
     *
     * @mbggenerated Wed Aug 23 23:20:57 CST 2023
     */
    int insert(Emp2 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_emp
     *
     * @mbggenerated Wed Aug 23 23:20:57 CST 2023
     */
    Emp2 selectByPrimaryKey(Integer empId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_emp
     *
     * @mbggenerated Wed Aug 23 23:20:57 CST 2023
     */
    List<Emp2> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_emp
     *
     * @mbggenerated Wed Aug 23 23:20:57 CST 2023
     */
    int updateByPrimaryKey(Emp2 record);
}