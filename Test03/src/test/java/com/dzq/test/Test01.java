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
import java.util.List;

/**
 * @Auther: x_mitsui
 * @Date: 2022/7/22 - 07 - 22 - 09:54
 * @Description: com.dzq.test
 * @version: 1.0
 */
public class Test01 {
    private SqlSession sqlSession;
    @Before
    public void aaa(){
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
    public void testFindAll(){
        // MyBatis内部辅助构造了实现类
        EmpMapper empImp = sqlSession.getMapper(EmpMapper.class);
        List<Emp> empList = empImp.findAll();
        empList.forEach(System.out::println);
    }
    @After
    public void bbb(){
        sqlSession.close();

    }
}
