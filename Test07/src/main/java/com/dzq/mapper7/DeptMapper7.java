package com.dzq.mapper7;

import com.dzq.pojo7.Dept;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @Auther: x_mitsui
 * @Date: 2022/7/22 - 07 - 22 - 19:28
 * @Description: com.dzq.mapper
 * @version: 1.0
 */
public interface DeptMapper7 {
    /**
     * 根据部门号查询部门信息，并展示部门员工
     * @param DeptNo
     * @return
     */
    Dept findDeptByDeptNo(int DeptNo);

    @Select("select * from DEPT where DEPTNO=#{deptno}")
    Dept findByDeptnoAnnotation(int DeptNo);

    @Update("update DEPT set DNAME=#{name} where DEPTNO=#{DeptNo}")
    int updateDeptNameByDeptNo(int DeptNo,String name);

    @Insert("insert into DEPT values (DEFAULT,#{arg0},#{arg1})")
    int insertDept(String dname,String loc);

    @Delete("delete from DEPT where DEPTNO=#{depnO}")
    int deleteDept(int depnO);
}
