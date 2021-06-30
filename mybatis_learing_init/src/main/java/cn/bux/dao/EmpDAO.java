package cn.bux.dao;

import cn.bux.entity.Emp;
import cn.bux.utils.MybatisUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpDAO {
    //根据id查询
    public Emp findById(String id);

    //多参数查询,根据id和name查询
    public Emp findByAgeAndSalary(@Param("age") String age, @Param("salary") String salary);

    //查询所有
    public List<Emp> findAll();

    //更新员工
    public void update(Emp emp);

    //删除
    public void delete(String id);

    //插入
    public void insert(Emp emp);

}
