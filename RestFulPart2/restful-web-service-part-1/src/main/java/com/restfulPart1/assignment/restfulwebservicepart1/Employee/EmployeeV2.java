package com.restfulPart1.assignment.restfulwebservicepart1.Employee;

import jakarta.persistence.criteria.CriteriaBuilder;

public class EmployeeV2 {
    private Long id;
    private String fName;

    private String lName;

    private Integer age;

    public EmployeeV2(Long id, String fName, String lName, Integer age) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.age = age;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "EmployeeV2{" +
                "id=" + id +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", age=" + age +
                '}';
    }
}
