package cn.bux.entity;

import java.util.Date;

public class Emp {
    private Integer id;

    private String name;

    private Integer age;

    private Date birthday;

    private Integer deptid;

    public Emp() {
    }

    public Emp(Integer id, String name, Integer age, Date birthday, Integer deptid) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.birthday = birthday;
        this.deptid = deptid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", deptid=" + deptid +
                '}';
    }
}
