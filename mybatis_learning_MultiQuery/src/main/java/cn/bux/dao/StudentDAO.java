package cn.bux.dao;

import cn.bux.entity.Student;


public interface StudentDAO {
    //查询学生信息并查询所选课程
    Student queryById(Integer id);
}
