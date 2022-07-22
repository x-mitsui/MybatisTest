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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: x_mitsui
 * @Date: 2022/7/22 - 07 - 22 - 16:08
 * @Description: com.dzq.test
 * @version: 1.0
 */
public class Test04 {
    private SqlSession sqlSession;

    @BeforeEach
    public void a() {
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
    public void testInsert() {
        Emp emp = new Emp(
                null, "三8", "开车", "7782", new Date(), 8800.0, null, 20
        );
        int rlt = sqlSession.insert("addEmp", emp);
        System.out.println("插入结果："+rlt);

    //    如果rollingback就手动commit
    //    sqlSession.commit();
    //    也可以sqlSession = factory.openSession(true);来设置事务自动提交
    }

    @Test
    public void testUpdate() {
        Emp emp = new Emp();
        emp.setEmpNo(7938);
        emp.setEName("周呜呜");
        int rlt = sqlSession.update("updateEmp", emp);
        System.out.println("更改结果："+rlt);
    }

    @Test
    public void testDelete() {
        int rlt = sqlSession.delete("deleteEmp", 7938);
        System.out.println("删除结果："+rlt);
    }



    @AfterEach
    public void b() {
        sqlSession.close();

    }
}
