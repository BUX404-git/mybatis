package cn.bux.dao;

import cn.bux.entity.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpDAO {

    //根据id查询
    public Emp findById(Integer id);

    //更新
    public void save(Emp emp);

    //删除
    public void delete(Integer id);

    //查询所有
    public List<Emp> findAll();

    //模糊查询
    public List<Emp> findLikeByName(String name);

    //分页查询
    public List<Emp> QueryByPage(@Param("start") Integer start,@Param("rows") Integer rows);

    //查询总条数
    public long queryTotalCounts();
}
