package com.dzq.test;

import com.dzq.mapper7.DeptMapper7;
import com.dzq.pojo7.Dept;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

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
        sqlSession = factory.openSession();
    }

    @Test
    public void testAnnotationInsert() {
        DeptMapper7 deptMapper = sqlSession.getMapper(DeptMapper7.class);
        deptMapper.insertDept("总部","上海");
        sqlSession.commit();
    }

    @Test
    public void testAnnotationUpdate() {
        DeptMapper7 deptMapper = sqlSession.getMapper(DeptMapper7.class);
        deptMapper.updateDeptNameByDeptNo(46,"总部2");
        sqlSession.commit();
    }

    @Test
    public void testAnnotationSelect() {
        DeptMapper7 deptMapper = sqlSession.getMapper(DeptMapper7.class);
        System.out.println(deptMapper.findByDeptnoAnnotation(46));
    }

    @Test
    public void testAnnotationDelete() {
        DeptMapper7 deptMapper = sqlSession.getMapper(DeptMapper7.class);
        deptMapper.deleteDept(46);
        sqlSession.commit();
    }






    @After
    public void bbb() {
        sqlSession.close();

    }
}
