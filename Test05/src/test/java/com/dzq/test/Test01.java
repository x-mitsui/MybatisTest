package com.dzq.test;

import com.dzq.mapper5.DeptMapper5;
import com.dzq.mapper5.EmpMapper5;
import com.dzq.pojo5.Dept;
import com.dzq.pojo5.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: x_mitsui
 * @Date: 2022/7/22 - 07 - 22 - 09:54
 * @Description: com.dzq.test
 * @version: 1.0
 */
public class Test01 {
    private SqlSession sqlSession;

    @Before
    public void aaa() {
        SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");//找导出目录class下文件
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory factory = ssfb.build(resourceAsStream);
        sqlSession = factory.openSession();
    }

    @Test
    public void testOneToOne() {
        EmpMapper5 mapper = sqlSession.getMapper(EmpMapper5.class);
        Emp empJoinDeptByEmpNo = mapper.findEmpJoinDeptByEmpNo(7499);
        System.out.println(empJoinDeptByEmpNo);
    }

    @Test
    public void testOneToMany() {
        DeptMapper5 mapper = sqlSession.getMapper(DeptMapper5.class);
        Dept deptJoinEmpByDeptNo = mapper.findDeptJoinEmpByDeptNo(20);
        System.out.println(deptJoinEmpByDeptNo);
        deptJoinEmpByDeptNo.getEmpList().forEach(System.out::println);
    }

    @After
    public void bbb() {
        sqlSession.close();

    }
}
