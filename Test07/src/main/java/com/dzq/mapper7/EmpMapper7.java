package com.dzq.mapper7;

import com.dzq.pojo7.Emp;

import java.util.List;

/**
 * @Auther: x_mitsui
 * @Date: 2022/7/22 - 07 - 22 - 19:28
 * @Description: com.dzq.mapper
 * @version: 1.0
 */
public interface EmpMapper7 {
    /**
     * 根据员工编号查询员工详细信息以及部门信息
     *
     * @return EMP对象，组合了Dept对象
     */
    List<Emp> findEmpByDeptNo(int DeptNo);

}
