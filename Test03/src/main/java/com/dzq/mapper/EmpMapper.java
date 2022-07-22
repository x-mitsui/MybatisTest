package com.dzq.mapper;

import com.dzq.pojo2.Emp;

import java.util.List;

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
}
