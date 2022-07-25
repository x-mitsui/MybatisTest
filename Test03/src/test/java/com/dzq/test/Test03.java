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
import java.util.Date;

/**
 * @Auther: x_mitsui
 * @Date: 2022/7/22 - 07 - 22 - 09:54
 * @Description: com.dzq.test
 * @version: 1.0
 */
public class Test03 {
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
    public void testAddEmp(){
        EmpMapper empImp = sqlSession.getMapper(EmpMapper.class);
        Emp emp = new Emp(null,"张三", "司机", "7566",new Date(),2800.0,null,40);
        System.out.println(emp);
        empImp.addEmp(emp);
        System.out.println(emp);//通过结果观察到，主键的值填回给了引用对象
    }

    @Test
    public void testUpdateENameByEno(){
        EmpMapper empImp = sqlSession.getMapper(EmpMapper.class);
        //System.out.println(emp.getEmpNo());
        empImp.updateEmpByEmpNo(7942,"李四");
        //System.out.println(emp.getEmpNo());//通过结果观察到，主键的值填回给了引用对象
    }

    @Test
    public void testDeleteEmpByEno(){
        EmpMapper empImp = sqlSession.getMapper(EmpMapper.class);
        empImp.deleteEmp(7941);
    }


    @After
    public void bbb() {
        sqlSession.close();

    }
}
