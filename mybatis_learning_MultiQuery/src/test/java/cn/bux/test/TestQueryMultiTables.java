package cn.bux.test;

import cn.bux.dao.*;
import cn.bux.entity.*;
import cn.bux.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import javax.annotation.Resources;
import java.io.IOException;
import java.util.List;

public class TestQueryMultiTables {

    //保存身份信息
    @Test
    public void TestSaveInfo() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try {
            InfoDAO infoDAO = sqlSession.getMapper(InfoDAO.class);
            Info info = new Info();
            info.setCardno("430903200104124532");
            info.setAddress("上海奉贤");
            int i = infoDAO.save(info);
            System.out.println(i);
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    //保存用户信息
    @Test
    public void TestSavePerson(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try {
            PersonDAO personDAO = sqlSession.getMapper(PersonDAO.class);
            Person person = new Person();
            person.setName("阿兹尔");
            person.setAge(141);
            person.setCardno("430903200104124532");
            int i = personDAO.save(person);
            sqlSession.commit();
            System.out.println(i);
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }

    //查询所有用户信息
    @Test
    public void TestQueryAll() throws IOException {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        PersonDAO personDAO = sqlSession.getMapper(PersonDAO.class);
        List<Person> people = personDAO.queryAll();
        people.forEach(person -> System.out.println("用户信息:" + person + "身份信息:" + person.getInfo()));
        sqlSession.close();
    }

    //查询所有部门信息和每个部门的所有员工信息
    @Test
    public void TestqueryAll(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        DeptDAO deptDAO = sqlSession.getMapper(DeptDAO.class);
        List<Dept> depts = deptDAO.queryAll();
        depts.forEach(dept -> System.out.println("部门信息=====>" + dept + "员工信息=====>" + dept.getEmps()));
    }

    //查询学生并查询学生选择的课程
    @Test
    public void TestQueryStudentAll(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDAO studentDAO = sqlSession.getMapper(StudentDAO.class);
        Student student = studentDAO.queryById(12);
        List<Course> courses = student.getCourses();
        System.out.println("学生信息:"+student);
        courses.forEach(course -> System.out.println("course = " + course));
        MybatisUtils.close(sqlSession);
    }


    //查询课程信息和选择该课程的学生信息
    @Test
    public void TestQueryCourseAll(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        CourseDAO courseDAO = sqlSession.getMapper(CourseDAO.class);
        Course course = courseDAO.queryCourseAllById(1);
        System.out.println("课程信息:"+course);
        course.getStudents().forEach(student -> System.out.println("选择该课程的学生信息" + student));
        MybatisUtils.close(sqlSession);
    }

}
