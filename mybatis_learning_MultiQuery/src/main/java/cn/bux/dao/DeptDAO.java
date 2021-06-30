package cn.bux.dao;

import cn.bux.entity.Dept;
import cn.bux.entity.Emp;
import cn.bux.entity.Person;

import java.util.List;

public interface DeptDAO {


    //查询所有部门信息和每个部门的员工信息
    public List<Dept> queryAll();
}
