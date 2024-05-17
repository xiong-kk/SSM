package com.free.mybatis.mapper;

import com.free.mybatis.pojo.Dept3;
import com.free.mybatis.pojo.Dept3Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Dept3Mapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dept
     *
     * @mbggenerated Wed Aug 23 23:28:27 CST 2023
     */
    int countByExample(Dept3Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dept
     *
     * @mbggenerated Wed Aug 23 23:28:27 CST 2023
     */
    int deleteByExample(Dept3Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dept
     *
     * @mbggenerated Wed Aug 23 23:28:27 CST 2023
     */
    int deleteByPrimaryKey(Integer deptId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dept
     *
     * @mbggenerated Wed Aug 23 23:28:27 CST 2023
     */
    int insert(Dept3 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dept
     *
     * @mbggenerated Wed Aug 23 23:28:27 CST 2023
     */
    int insertSelective(Dept3 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dept
     *
     * @mbggenerated Wed Aug 23 23:28:27 CST 2023
     */
    List<Dept3> selectByExample(Dept3Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dept
     *
     * @mbggenerated Wed Aug 23 23:28:27 CST 2023
     */
    Dept3 selectByPrimaryKey(Integer deptId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dept
     *
     * @mbggenerated Wed Aug 23 23:28:27 CST 2023
     */
    int updateByExampleSelective(@Param("record") Dept3 record, @Param("example") Dept3Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dept
     *
     * @mbggenerated Wed Aug 23 23:28:27 CST 2023
     */
    int updateByExample(@Param("record") Dept3 record, @Param("example") Dept3Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dept
     *
     * @mbggenerated Wed Aug 23 23:28:27 CST 2023
     */
    int updateByPrimaryKeySelective(Dept3 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dept
     *
     * @mbggenerated Wed Aug 23 23:28:27 CST 2023
     */
    int updateByPrimaryKey(Dept3 record);
}