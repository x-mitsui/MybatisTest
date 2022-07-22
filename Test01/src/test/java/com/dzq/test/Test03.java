package com.dzq.test;

import com.dzq.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Auther: x_mitsui
 * @Date: 2022/7/22 - 07 - 22 - 16:08
 * @Description: com.dzq.test
 * @version: 1.0
 */
public class Test03 {
    private SqlSession sqlSession;
    @BeforeEach
    public void a(){
        SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
        InputStream resourceAsStream=null;
        try {
            resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");//找导出目录class下文件
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory factory = ssfb.build(resourceAsStream);
        sqlSession = factory.openSession();
    }
    @Test
    public void testSingleArg(){
        Emp emp = sqlSession.selectOne("findEmpByEmpNo",7521);
        System.out.println(emp);
    }
    @Test
    public void testMapArg(){
        Map<String, Integer> args = new HashMap<>();
        args.put("DepNo",20);
        args.put("sal",1500);
        List<Emp> empList = sqlSession.selectList("findEmpByEmpNoAndSalary", args);
        empList.forEach(System.out::println);

    }
    @Test
    public void testEmpArg(){
        Emp args = new Emp();
        args.setDeptNo(20);
        args.setSal(1500.0);
        List<Emp> empList = sqlSession.selectList("findEmpByEmpNoAndSalary2", args);
        empList.forEach(System.out::println);

    }

    @AfterEach
    public void b(){
        sqlSession.close();

    }
}
