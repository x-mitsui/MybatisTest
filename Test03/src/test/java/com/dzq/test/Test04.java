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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
    public void testFindByCondition2() throws ParseException {
        EmpMapper2 empImp = sqlSession.getMapper(EmpMapper2.class);
        Emp emp = new Emp();
        emp.setHireDate(new SimpleDateFormat("yyyy-MM-dd").parse("1981-09-28"));
        List<Emp> emps = empImp.findEmpByCondition2(emp);
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

    @Test
    public void testUpdateEmpByCondition() throws ParseException {
        EmpMapper2 empImp = sqlSession.getMapper(EmpMapper2.class);
        Emp emp = new Emp();
        emp.setEmpNo(7943);
        emp.setEName("赵五");
        emp.setHireDate(new SimpleDateFormat("yyyy-MM-dd").parse("1990-08-03"));
        int result = empImp.updateEmpByCondition(emp);
        System.out.println(result);
    }

    @Test
    public void testUpdateEmpByCondition2() throws ParseException {
        EmpMapper2 empImp = sqlSession.getMapper(EmpMapper2.class);
        Emp emp = new Emp();
        emp.setEmpNo(7943);
        emp.setEName("赵小五");
        emp.setHireDate(new SimpleDateFormat("yyyy-MM-dd").parse("1980-08-03"));
        int result = empImp.updateEmpByCondition(emp);
        System.out.println(result);
    }

    @Test
    public void testFindEmpByEmpNos1(){
        EmpMapper2 empImp = sqlSession.getMapper(EmpMapper2.class);
        Emp emp = new Emp();
        List<Emp> emps = empImp.findEmpByEmpNos1(new int[]{7968,7782,7788});
        emps.forEach(System.out::println);
    }

    @Test
    public void testFindEmpByEmpNos2(){
        EmpMapper2 empImp = sqlSession.getMapper(EmpMapper2.class);
        List list = new ArrayList();
        //list.add(7698);
        //list.add(7782);
        //list.add(7788);
        Collections.addAll(list,7698,7782,7788);
        List<Emp> emps = empImp.findEmpByEmpNos2(list);
        emps.forEach(System.out::println);
    }

    @After
    public void bbb() {
        sqlSession.close();

    }
}
