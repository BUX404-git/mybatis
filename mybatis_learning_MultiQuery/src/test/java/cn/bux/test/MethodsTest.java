package cn.bux.test;

import cn.bux.dao.EmpDAO;
import cn.bux.entity.Emp;
import cn.bux.utils.MybatisUtils;
import org.junit.jupiter.api.Test;

public class MethodsTest {

    @Test
    public void TestfidById(){
        EmpDAO mapper = MybatisUtils.getSqlSession().getMapper(EmpDAO.class);
        Emp emp = mapper.findById(1);
        System.out.println(emp);
    }
}
