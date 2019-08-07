package cn.com.star.lanmbda.stream;

import cn.com.star.lanmbda.mock.MockUtil;
import cn.com.star.lanmbda.model.Student;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * stream()流 是一种来自数据源的元素队列并支持聚合操作
 * 元素:是特定的类型对象，形成一个队列
 * 数据源：流的来源。 可以是集合, 数组, I/O channel
 * 聚合操作: 类似sql语句一样, 如filter/map/reduce/find/match/sorted.
 * pipelining: 中间操作都会返回对象本身
 * 内部迭代： stream 提供内部迭代，通过访问者模式vistor实现
 */
public class LambdaSimpleStream {
    public static void main(String[] args) {
        LambdaSimpleStream lambdaSimpleStream = new LambdaSimpleStream();
        lambdaSimpleStream.buildStream();
        lambdaSimpleStream.forEach();
        lambdaSimpleStream.map();
        lambdaSimpleStream.filter();
        lambdaSimpleStream.limit();
        lambdaSimpleStream.sorted();
        lambdaSimpleStream.collectors();
    }

    /**
     * stream()- 为集合创建串行流
     * parallelStream() - 为集合创建并行流
     */
    private void buildStream() {
        List<Student> studentList = MockUtil.getStudents();
        studentList.stream().filter(student -> student.getName().equals("star")).collect(Collectors.toList());
        studentList.parallelStream().filter(student -> student.getName().equals("star")).collect(Collectors.toList());
    }

    /**
     * for each 循环
     */
    private void forEach() {
        List<Student> studentList = MockUtil.getStudents();
        studentList.forEach(student -> System.out.println("for each 循环后得到 name = " + student.getName()));
    }

    /**
     * map 方法用于映射每个元素对应的结果。 取出对象的部分属性并将其转化为特定的list
     */
    private void map() {
        List<Student> studentList = MockUtil.getStudents();
        List<String> sumIds = studentList.stream().map(student -> student.getName() + "map").collect(Collectors.toList());
        sumIds.forEach(id -> System.out.println("stream map 的使用后 id =" + id));
    }


    /**
     * filter方法用于通过设置条件过滤元素
     */
    private void filter() {
        List<Student> studentList = MockUtil.getStudents();
        studentList.stream().filter(student -> student.getName().contains("a")).forEach(student -> System.out.println("stream filter 过滤含有'a'字符的 student name=" + student.getName()));
    }

    /**
     * limit 方法用于获取指定数量的流
     */
    private void limit() {
        List<Student> studentList = MockUtil.getStudents();
        studentList.stream().limit(2).forEach(student -> System.out.println("stream limit 获取前两个学生姓名 =" + student.getName()));
    }

    /**
     * sorted 排序
     */
    private void sorted() {
        List<Student> studentList = MockUtil.getStudents();
        studentList.stream().sorted(Comparator.comparing(student -> student.getAge())).forEach(student -> System.out.println("stream sorted排序 获取前学生姓名 =" + student.getName()));
    }

    /**
     * 流转换成集合和聚合元素
     */
    private void collectors() {
        List<Student> studentList = MockUtil.getStudents();
        Map<Integer, List<Student>> studentMap = studentList.stream().collect(Collectors.groupingBy(Student::getId));
    }
}
