package cn.com.star.lanmbda.listmap;

import cn.com.star.lanmbda.mock.MockUtil;
import cn.com.star.lanmbda.model.Student;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * This is a lambda list
 * lambda 在list中的应用
 * 1： list sorted comparing
 * 2： list filter predicate
 * 3： list 转 map groupingby
 * 4： list 中部分属性转map
 * 5： list 转set
 * 6： map 遍历
 * 7： map转list
 * 8： map中提取value 或者key add to list
 */
public class LambdaSimpleListMap {
    private List<Student> studentList = null;

    public static void main(String[] args) {
        LambdaSimpleListMap lambdaSimpleUsage = new LambdaSimpleListMap();
        lambdaSimpleUsage.sorted();
        lambdaSimpleUsage.filter();
        lambdaSimpleUsage.groupingBy();
        lambdaSimpleUsage.convertToMapAndSorted();
        lambdaSimpleUsage.convertToSet();
        lambdaSimpleUsage.mapToList();
    }

    /**
     * 正向和逆向排序.
     */
    private void sorted() {
        studentList = MockUtil.getStudents();
        //正向排序
        studentList.stream().sorted(Comparator.comparing(Student::getId)).forEach(student -> System.out.println("sort by id = " + student.getId() + " and student name = " + student.getName()));
        //逆向排序
        studentList.stream().sorted(Comparator.comparing(Student::getId).reversed()).forEach(student -> System.out.println("sort by id = " + student.getId() + " and student name = " + student.getName()));
    }

    /**
     * 多种条件混合后的过滤
     */
    private void filter() {
        Predicate<Student> nameContains = student -> student.getName().contains("a");
        Predicate<Student> ageUpper = student -> student.getAge() >= 30;
        studentList.stream().filter(nameContains.and(ageUpper)).forEach(student -> System.out.println("filter 过后的学生姓名" + student.getName()));
    }

    /**
     * list中grouping by转化成map<k,v>
     */
    private void groupingBy() {
        Map<Integer, List<Student>> studentMap = (HashMap<Integer, List<Student>>) studentList.stream().collect(Collectors.groupingBy(Student::getId));
        studentMap.forEach((k, v) -> System.out.println("得到key = " + k + "得到value = " + v.stream().map(Student::getName).collect(Collectors.joining(","))));
    }

    /**
     * 将list转化成map并对map的key value排序
     */
    private void convertToMapAndSorted() {
        Map<Integer, String> studentMap = studentList.stream().collect(Collectors.toMap(Student::getId, Student::getName));
        studentMap.forEach((k,v)-> System.out.println("key = "+ k+" value = " + v));
        Map<Integer, String> studentSortedMap = studentMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(oldValue, newValue)->oldValue, LinkedHashMap::new));
        studentMap.forEach((k,v)-> System.out.println("倒序过后的map key = "+ k+" value = " + v));
    }

    /**
     * 将list转换成set
     */
    private void convertToSet() {
        Set<Student> studentSet= studentList.stream().collect(Collectors.toSet());
        studentSet.forEach(System.out::println);
    }

    /**
     * 将map的key and value 转换成list
     */
    private void mapToList() {
        Map<Integer, String> studentMap = studentList.stream().collect(Collectors.toMap(Student::getId, Student::getName));
        List<String> valueList = studentMap.entrySet().stream().map(value->value.getValue()).collect(Collectors.toList());
        valueList.forEach(value-> System.out.println("map to list value = "+value));

        List<Integer> keyList = studentMap.keySet().stream().collect(Collectors.toList());
        keyList.forEach(key-> System.out.println("map to list key = "+ key));
    }

}
