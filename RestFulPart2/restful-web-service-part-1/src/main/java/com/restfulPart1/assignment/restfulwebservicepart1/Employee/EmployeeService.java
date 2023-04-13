package com.restfulPart1.assignment.restfulwebservicepart1.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeService {

    private static List<Employee> employeeList=new ArrayList<>();

    private static List<EmployeeV2> employeeV2List=new ArrayList<>();

    private static Long id1= 0L;
    private static Long id2= 0L;


    static {
        employeeList.add(new Employee(++id1,"Karan Guliani",25));
        employeeList.add(new Employee(++id1,"Manav Garg",22));
        employeeList.add(new Employee(++id1,"Anshul Gupta",23));
        employeeV2List.add(new EmployeeV2(++id2,"Karan","Guliani",25));
        employeeV2List.add(new EmployeeV2(++id2,"Manav","Garg",22));
        employeeV2List.add(new EmployeeV2(++id2,"Anshul","Gupta",23));


    }

    public List<Employee> findAll(){
        return employeeList;
    }

    public Employee findById(Long id){
       return employeeList.stream()
               .filter(employee -> employee.getId().equals(id))
               .findFirst()
               .orElse(null);
    }

    public Employee addEmployee(Employee employee){
        employee.setId(++id1);
        employeeList.add(employee);
        return employee;
    }

    public void deleteById(Long id){
        employeeList.removeIf(employee -> employee.getId().equals(id));
    }

    public void updateById(Long id,Employee employee1){
        Employee emp=employeeList.stream()
                .filter(employee -> employee.getId().equals(id))
                .findFirst()
                .get();

        emp.setName(employee1.getName());
        emp.setAge(employee1.getAge());

    }

    public List<EmployeeV2> findAllV2(){
        return employeeV2List;
    }


}
