package com.dzq.mapper;

import com.dzq.pojo2.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Auther: x_mitsui
 * @Date: 2022/7/22 - 07 - 22 - 19:28
 * @Description: com.dzq.mapper
 * @version: 1.0
 */
public interface EmpMapper {
    /**
     * 返回所有员工的信息
     * @return 返回包含Emp类型对象的List集合
     */
    List<Emp> findAll();

    /**
     * 通过员工编号查询单个员工信息的方法
     * @param num 员工编号
     * @return Emp对象；找不到返回null
     */
    Emp findByEmpNo(int num);

    List<Emp> findEmpByDeptNoAndSalary(int deptNo,double sal);

    List<Emp> findEmpByDeptNoAndSalary2(Map map);

    List<Emp> findEmpByDeptNoAndSalary3(Emp emp);

    List<Emp> findEmpByDeptNoAndSalary4(Emp emp0, Emp emp1);

    List<Emp> findEmpByDeptNoAndSalary5(@Param("empA") Emp emp0, @Param("empB") Emp emp1);

    /**
     * 根据员工名字模糊匹配多个员工
     * @param eName 员工名字片段
     * @return 多个员工对象集合
     */
    List<Emp> findByName(String eName);

}
