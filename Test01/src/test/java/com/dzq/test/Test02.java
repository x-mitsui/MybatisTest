package com.dzq.test;

import com.dzq.pojo.Dept;
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
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Auther: x_mitsui
 * @Date: 2022/7/22 - 07 - 22 - 16:08
 * @Description: com.dzq.test
 * @version: 1.0
 */
public class Test02 {
    private SqlSession sqlSession;
    @BeforeEach
    public void boot(){
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
    public void testFindOne(){
        Emp emp = sqlSession.selectOne("findOne");
        System.out.println(emp);

    }
    @Test
    public void testFindAll(){
        List<Emp> list = sqlSession.selectList("yyy.findAll");
        list.forEach(System.out::println);
        /**
         * Emp(EmpNo=7369, EName=SMITH, Job=CLERK, MGR=7902, HireDate=Wed Dec 17 00:00:00 CST 1980, Sal=800.0, Comm=null, DeptNo=20)
         * Emp(EmpNo=7499, EName=ALLEN,....
         * ...
         */
    }
    @Test
    // 不常见
    public void testFindAllMap(){
        Map<Integer, Emp> EmpMap = sqlSession.selectMap("findEmpMap", "EmpNo");
        Set<Integer> empnos = EmpMap.keySet();
        for (Integer empno : empnos) {
            System.out.println(empno+" :"+EmpMap.get(empno));
            /**
             * 7521 :Emp(EmpNo=7521, EName=WARD, Job=SALESMAN, MGR=7698, HireDate=Sun Feb 22 00:00:00 CST 1981, Sal=1250.0, Comm=500.0, DeptNo=30)
             * 7844 :Emp(EmpNo=7844, EName=TURNER....
             * ...
             */
        }
    }
    @AfterEach
    public void release(){
        sqlSession.close();

    }
}
