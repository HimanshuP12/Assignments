package com.restfulPart1.assignment.restfulwebservicepart1.Employee;

import com.restfulPart1.assignment.restfulwebservicepart1.Exception.ResourceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeService {

    private static List<Employee> employeeList=new ArrayList<>();

    private static Long id= 0L;

    static {
        employeeList.add(new Employee(++id,"Karan Guliani",25));
        employeeList.add(new Employee(++id,"Manav Garg",22));
        employeeList.add(new Employee(++id,"Anshul Gupta",23));
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
        employee.setId(++id);
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


}
