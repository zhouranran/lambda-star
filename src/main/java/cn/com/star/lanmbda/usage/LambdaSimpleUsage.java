package cn.com.star.lanmbda.usage;

import cn.com.star.lanmbda.mock.MockUtil;
import cn.com.star.lanmbda.model.Student;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * This is a simple lambda usage
 * lambda 的一些简单场景应用
 * 1： Thead Runnable
 */
public class LambdaSimpleUsage {
    public static void main(String[] args) {
        LambdaSimpleUsage lambdaSimpleUsage = new LambdaSimpleUsage();
        lambdaSimpleUsage.showRunnable();
        lambdaSimpleUsage.addClickListener();
        lambdaSimpleUsage.addPredicate();
        lambdaSimpleUsage.createListAfterFilter();
        lambdaSimpleUsage.joinString();
    }


    /**
     * Lambda usage in the new Runnable()
     */
    private void showRunnable() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("normal use in thread");
            }
        });

        new Thread(() -> System.out.println("Lambda use in thread")).start();
    }

    /**
     * Lambda usage in the click listener
     */
    private void addClickListener() {
        JButton jButton = new JButton();
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Lambda usage in add listener");
            }
        });

        jButton.addActionListener(e -> System.out.println("Lambda usage in add listener"));
        //or
        //jButton.addActionListener(e -> {do something...});
    }

    /**
     * Predicate 提供or 或者and method 并传入filter.
     */
    private void addPredicate() {
        List<Student> studentList = MockUtil.getStudents();
        Predicate<Student>  nameEquals = student -> "star".equals(student.getName());
        Predicate<Student>  nameContains = student -> student.getName().contains("a");
        //This method will println the star and raymond and eason
        studentList.stream().filter(nameEquals.or(nameContains)).forEach(student-> System.out.println(student.getName()));
    }

    /**
     * create a list after filter
     */
    private void createListAfterFilter() {
        List<Student> studentList = MockUtil.getStudents();
        List<Student> newStudentList = studentList.stream().filter(student -> student.getId()>2).collect(Collectors.toList());
        //This method will println the eason and belen
        newStudentList.forEach(student -> System.out.println("create a new student list by filter the id >2 " + student.getName()));
    }

    /**
     * join the list
     */
    private void joinString() {
        List<Student> studentList = MockUtil.getStudents();
        String  joinString = studentList.stream().map(student-> student.getName().toUpperCase()).collect(Collectors.joining(", "));
        System.out.println("join the lis:"+joinString);
    }

}
