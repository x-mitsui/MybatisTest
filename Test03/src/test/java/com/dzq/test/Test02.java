package com.dzq.test;

import com.dzq.mapper.DeptMapper;
import com.dzq.mapper.EmpMapper;
import com.dzq.pojo2.Dept;
import com.dzq.pojo2.Emp;
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
public class Test02 {
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
    public void testAddDept(){
        DeptMapper depImp = sqlSession.getMapper(DeptMapper.class);
        Dept dept = new Dept();
        dept.setDName("教学部");
        dept.setLoc("北京");
        System.out.println(dept);
        depImp.addDept(dept);
        System.out.println(dept);//通过结果观察到，主键的值填回给了引用对象
    }

    @Test
    public void testAddDept2(){
        DeptMapper depImp = sqlSession.getMapper(DeptMapper.class);
        Dept dept = new Dept();
        dept.setDName("教学部");
        dept.setLoc("北京");
        System.out.println(dept);
        depImp.addDept2(dept);
        System.out.println(dept);//通过结果观察到，主键的值填回给了引用对象
    }

    @After
    public void bbb() {
        sqlSession.close();

    }
}
