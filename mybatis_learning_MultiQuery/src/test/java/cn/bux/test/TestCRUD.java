package cn.bux.test;

import cn.bux.dao.EmpDAO;
import cn.bux.entity.Emp;
import cn.bux.utils.MybatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class TestCRUD {

    @Test
    public void save(){

        SqlSession sqlSession = null;
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            sqlSession = sqlSessionFactory.openSession();
            EmpDAO empDAO = sqlSession.getMapper(EmpDAO.class);
            empDAO.save(new Emp(1,"zhangsna",25,null,2));
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        }

    }

    @Test
    public void delete(){
        SqlSession sqlSession = null;
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            sqlSession = sqlSessionFactory.openSession();
            EmpDAO empDAO = sqlSession.getMapper(EmpDAO.class);
            empDAO.delete(3);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        }

    }

    @Test
    public void TestfindAll() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sessionFactory.openSession();
        EmpDAO empDAO = sqlSession.getMapper(EmpDAO.class);
        List<Emp> emps = empDAO.findAll();
        emps.forEach(emp -> System.out.println("emp = " + emp));
    }

    @Test
    public void TestfindLikeByName() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpDAO empDAO = sqlSession.getMapper(EmpDAO.class);
        empDAO.findLikeByName("小").forEach(emp -> System.out.println("emp = " + emp));
    }

    @Test
    public void TestQueryByPage() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpDAO empDAO = sqlSession.getMapper(EmpDAO.class);
        List<Emp> emps = empDAO.QueryByPage(2, 2);
        emps.forEach(emp -> System.out.println("emp = " + emp));
    }

    @Test
    public void TestQueryTotalCounts() throws IOException{
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        long l = new SqlSessionFactoryBuilder().build(resourceAsStream).openSession().getMapper(EmpDAO.class).queryTotalCounts();
        System.out.println(l);
    }
}
