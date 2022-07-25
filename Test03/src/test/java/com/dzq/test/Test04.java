package com.dzq.test;

import com.dzq.mapper.EmpMapper;
import com.dzq.mapper.EmpMapper2;
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
import java.util.Date;
import java.util.List;

/**
 * @Auther: x_mitsui
 * @Date: 2022/7/22 - 07 - 22 - 09:54
 * @Description: com.dzq.test
 * @version: 1.0
 */
public class Test04 {
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
        sqlSession = factory.openSession(true);
    }

    @Test
    public void testFindByCondition1(){
        EmpMapper2 empImp = sqlSession.getMapper(EmpMapper2.class);
        Emp emp = new Emp();
        List<Emp> emps = empImp.findEmpByCondition(emp);
        emps.forEach(System.out::println);
    }

    @Test
    public void testFindByCondition2(){
        EmpMapper2 empImp = sqlSession.getMapper(EmpMapper2.class);
        Emp emp = new Emp();
        emp.setEmpNo(7782);
        List<Emp> emps = empImp.findEmpByCondition(emp);
        emps.forEach(System.out::println);
    }

    @Test
    public void testFindByCondition3(){
        EmpMapper2 empImp = sqlSession.getMapper(EmpMapper2.class);
        Emp emp = new Emp();
        emp.setEmpNo(7943);
        emp.setEName("张三");
        List<Emp> emps = empImp.findEmpByCondition(emp);
        emps.forEach(System.out::println);
    }

    @Test
    public void testFindByCondition4(){
        EmpMapper2 empImp = sqlSession.getMapper(EmpMapper2.class);
        Emp emp = new Emp();
        emp.setEName("张三");
        List<Emp> emps = empImp.findEmpByCondition(emp);
        emps.forEach(System.out::println);
    }




    @After
    public void bbb() {
        sqlSession.close();

    }
}