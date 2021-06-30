package cn.bux;

import cn.bux.dao.EmpDAO;
import cn.bux.entity.Emp;
import cn.bux.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;


public class test {
    public static void main(String[] args) throws IOException {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        EmpDAO empDAO = sqlSession.getMapper(EmpDAO.class);

        Emp emp = empDAO.findById("1");
        System.out.println(emp);
        sqlSession.close();
    }
}
