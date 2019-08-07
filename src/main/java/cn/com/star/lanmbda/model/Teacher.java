package cn.com.star.lanmbda.model;

import java.time.LocalDateTime;

public class Teacher {
    private String id;
    private String name;
    private SEX sex;
    private LocalDateTime dayOfBirth;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
