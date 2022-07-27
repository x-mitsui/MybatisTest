package com.dzq.mapper7;

import com.dzq.pojo7.Dept;

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
}
