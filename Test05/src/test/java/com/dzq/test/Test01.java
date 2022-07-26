package com.dzq.test;

import com.dzq.mapper5.DeptMapper5;
import com.dzq.mapper5.EmpMapper5;
import com.dzq.mapper5.ProjectMapper5;
import com.dzq.pojo5.Dept;
import com.dzq.pojo5.Emp;
import com.dzq.pojo5.Project;
import com.dzq.pojo5.ProjectRecord;
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
    public void testOneToOne() {
        EmpMapper5 mapper = sqlSession.getMapper(EmpMapper5.class);
        Emp empJoinDeptByEmpNo = mapper.findEmpJoinDeptByEmpNo(7499);
        System.out.println(empJoinDeptByEmpNo);
    }

    @Test
    public void testOneToMany() {
        DeptMapper5 mapper = sqlSession.getMapper(DeptMapper5.class);
        Dept deptJoinEmpByDeptNo = mapper.findDeptJoinEmpByDeptNo(20);
        System.out.println(deptJoinEmpByDeptNo);
        deptJoinEmpByDeptNo.getEmpList().forEach(System.out::println);
    }

    @Test
    public void testManyToMany() {
        ProjectMapper5 mapper = sqlSession.getMapper(ProjectMapper5.class);
        Project project = mapper.findProjectByProjectNo(2);
        System.out.println("------------------");
        System.out.println(project.getPid());
        System.out.println(project.getPname());
        System.out.println(project.getMoney());
        System.out.println("------------------");
        for (ProjectRecord projectRecord : project.getProjectRecordList()) {
            System.out.println("------------------");
            System.out.println(projectRecord.getEmp());
        }
    }

    @After
    public void bbb() {
        sqlSession.close();

    }
}
