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
public interface EmpMapper2 {
    /**
     * 根据动态条件返回员工的信息
     * @return 返回包含Emp类型对象的List集合
     */
    List<Emp> findEmpByCondition(Emp emp);


}
