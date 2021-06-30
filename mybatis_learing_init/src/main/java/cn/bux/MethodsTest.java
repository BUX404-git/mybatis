package cn.bux;

import cn.bux.dao.EmpDAO;
import cn.bux.entity.Emp;
import cn.bux.utils.MybatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MethodsTest {

    //单个查询
    @Test
    public void testFindById() throws Exception{
        //读取配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //创建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        //获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //直接通过sqlSession获取DAO对象
        EmpDAO empDAO = sqlSession.getMapper(EmpDAO.class);
        //调用方法
        Emp emp = empDAO.findById("2");
        System.out.println(emp);

    }

    //用多个参数查询
    @Test
    public void TestfindByAgeAndSalary() throws Exception{
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpDAO empDAO = sqlSession.getMapper(EmpDAO.class);
        Emp emp = empDAO.findByAgeAndSalary("25", "4500");
        System.out.println(emp);
    }

    //查询所有
    @Test
    public void TestfindAll() throws Exception{
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpDAO empDAO = sqlSession.getMapper(EmpDAO.class);
        List<Emp> list = empDAO.findAll();
        list.forEach(Emp -> System.out.println("emp = " + Emp));
    }

    //更新
    @Test
    public void Testupdate() throws Exception {
        SqlSession sqlSession = null;
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            sqlSession = sqlSessionFactory.openSession();
            EmpDAO empDAO = sqlSession.getMapper(EmpDAO.class);
            empDAO.update(new Emp(1,"Diana","ava",15000.0,16));
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        }
    }

    //删除
    @Test
    public void Testdelete() throws Exception{
        SqlSession sqlSession = null;
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            sqlSession = sqlSessionFactory.openSession();
            EmpDAO mapper = sqlSession.getMapper(EmpDAO.class);
            mapper.delete("4");
            sqlSession.commit();
        }catch (IOException e){
            e.printStackTrace();
            sqlSession.rollback();
        }
    }

    //插入
    @Test
    public void Testinsert() throws Exception{
        SqlSession sqlSession = null;
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            sqlSession = sqlSessionFactory.openSession();
            EmpDAO mapper = sqlSession.getMapper(EmpDAO.class);
            mapper.insert(new Emp(5,"赵信","zhaoxin",8484.0,38));
            sqlSession.commit();
        }catch (IOException e){
            e.printStackTrace();
            sqlSession.rollback();
        }
    }


}
