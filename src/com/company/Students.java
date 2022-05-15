package com.company;

import java.io.Serializable;

public class Students implements Serializable {

    @Annotation(params = "Student - name is ...")
    private String name;
    @Annotation(params = "Student - lastname is ...")
    private String lastname;
    @Annotation(params = "Student - course is ...")
    private int course;

    private int age;

    public Students(String name, String lastname, int course, int age) {
        this.name = name;
        this.lastname = lastname;
        this.course = course;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Students{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", course=" + course +
                ", age=" + age +
                '}';
    }


}
