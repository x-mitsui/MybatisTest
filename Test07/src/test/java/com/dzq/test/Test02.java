package com.dzq.test;

import com.dzq.mapper7.DeptMapper7;
import com.dzq.mapper7.EmpMapper7;
import com.dzq.pojo7.Dept;
import com.dzq.pojo7.Emp;
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
    // 测试积极加载
    public void testFindEmpByDeptNoAndFindDeptByDeptNo() {
        DeptMapper7 deptMapper = sqlSession.getMapper(DeptMapper7.class);
        Dept dept = deptMapper.findDeptByDeptNo(20);
        // 打开、关闭下面的注释来检查懒加载
        //System.out.println(dept.getDname());
        //System.out.println(dept.getLoc());
        //dept.getEmpList().forEach(System.out::println);
    }





    @After
    public void bbb() {
        sqlSession.close();

    }
}
