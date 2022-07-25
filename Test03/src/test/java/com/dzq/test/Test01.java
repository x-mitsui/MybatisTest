package com.dzq.test;

import com.dzq.mapper.EmpMapper;
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
    public void testFindAll() {
        // MyBatis内部辅助构造了实现类
        EmpMapper empImp = sqlSession.getMapper(EmpMapper.class);
        List<Emp> empList = empImp.findAll();
        empList.forEach(System.out::println);
    }

    @Test
    public void testFindOne() {
        EmpMapper empImp = sqlSession.getMapper(EmpMapper.class);
        Emp emp = empImp.findByEmpNo(7876);
        System.out.println(emp);
    }

    @Test
    public void testFindByMoreParas() {
        EmpMapper empImp = sqlSession.getMapper(EmpMapper.class);
        List<Emp> empList = empImp.findEmpByDeptNoAndSalary(20, 1500.0);
        empList.forEach(System.out::println);
    }

    @Test
    public void testFindByMoreParas2() {
        EmpMapper empImp = sqlSession.getMapper(EmpMapper.class);
        Map map = new HashMap<>();
        map.put("depno", 20);
        map.put("sal", 1500.0);
        List<Emp> empList = empImp.findEmpByDeptNoAndSalary2(map);
        empList.forEach(System.out::println);
    }

    @Test
    public void testFindByMoreParas3() {
        EmpMapper empImp = sqlSession.getMapper(EmpMapper.class);
        Emp emp = new Emp();
        emp.setDeptNo(20);
        emp.setSal(1500.0);
        List<Emp> empList = empImp.findEmpByDeptNoAndSalary3(emp);
        empList.forEach(System.out::println);
    }

    @Test
    public void testFindByMoreParas4() {
        EmpMapper empImp = sqlSession.getMapper(EmpMapper.class);
        Emp emp0 = new Emp();
        emp0.setDeptNo(20);
        Emp emp1 = new Emp();
        emp1.setSal(1500.0);
        List<Emp> empList = empImp.findEmpByDeptNoAndSalary4(emp0, emp1);
        empList.forEach(System.out::println);
    }

    @Test
    public void testFindByMoreParas5() {
        EmpMapper empImp = sqlSession.getMapper(EmpMapper.class);
        Emp emp0 = new Emp();
        emp0.setDeptNo(20);
        Emp emp1 = new Emp();
        emp1.setSal(1500.0);
        List<Emp> empList = empImp.findEmpByDeptNoAndSalary4(emp0, emp1);
        empList.forEach(System.out::println);
    }

    @Test
    public void testFindByName() {
        EmpMapper empImp = sqlSession.getMapper(EmpMapper.class);
        String name ="a";
        List<Emp> empList = empImp.findByName(name);
        empList.forEach(System.out::println);
    }

    @After
    public void bbb() {
        sqlSession.close();

    }
}
