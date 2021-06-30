package cn.bux.dao;

import cn.bux.entity.Person;

import java.util.List;

public interface PersonDAO {
    //保存用户信息
    public int save (Person person);

    //查询所有用户信息
    public List<Person> queryAll();
}
