package cn.com.star.lanmbda.mock;

import cn.com.star.lanmbda.model.Student;
import cn.com.star.lanmbda.model.Teacher;

import java.util.ArrayList;
import java.util.List;

public class MockUtil {
    //get the list of student
    public static List<Student> getStudents(){
        List<Student> studentList = new ArrayList<>();
        Student student = new Student();
        student.setId(1);
        student.setName("star");
        student.setAge(31);
        studentList.add(student);
        student = new Student();
        student.setId(2);
        student.setName("raymond");
        student.setAge(35);
        studentList.add(student);
        student = new Student();
        student.setId(3);
        student.setName("belen");
        student.setAge(38);
        studentList.add(student);
        student = new Student();
        student.setId(4);
        student.setName("eason");
        student.setAge(28);
        studentList.add(student);
        return studentList;
    }

    //get the list of teacher
    public static List<Teacher> getTeachers(){
        return null;
    }
}
