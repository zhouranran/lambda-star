package cn.com.star.lanmbda.mock;

import cn.com.star.lanmbda.model.Student;
import cn.com.star.lanmbda.model.Trader;
import cn.com.star.lanmbda.model.Transaction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MockUtil {
    //get the list of student
    public static List<Student> getStudents() {
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

    public static List<Transaction> getTransactionList() {

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950));

        return  transactions;
    }
}
