package cn.com.star.lanmbda.model;

import java.time.LocalDateTime;

public class Student {
    private int id;
    private String name;
    private SEX sex;
    private LocalDateTime dayOfBirth;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SEX getSex() {
        return sex;
    }

    public void setSex(SEX sex) {
        this.sex = sex;
    }

    public LocalDateTime getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(LocalDateTime dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }
}
