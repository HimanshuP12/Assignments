package com.restfulPart1.assignment.restfulwebservicepart1.Controller;

import com.restfulPart1.assignment.restfulwebservicepart1.Employee.Employee;
import com.restfulPart1.assignment.restfulwebservicepart1.Employee.EmployeeService;
import com.restfulPart1.assignment.restfulwebservicepart1.Exception.ResourceNotFound;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    EmployeeService employeeService;
    @RequestMapping("/Ques1")
    public String returnWelcomeMsg(){
        return "Welcome to spring boot";
    }

    @GetMapping("/employees")
    public List<Employee> retrieveAllEmployees(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee retrieveSingleEmployee(@PathVariable Long id){
        Employee emp=employeeService.findById(id);
        if(emp==null){
            throw new ResourceNotFound("ID: "+id);
        }
        return emp;
    }

    @PostMapping("/employees")
    public String createUser(@Valid @RequestBody Employee employee){
        employeeService.addEmployee(employee);
        return "Created Successfully";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id){
        employeeService.deleteById(id);
        return "Employee Deleted Successfully";
    }

    @PutMapping("/put/{id}")
    public String updateEmployeeDetails(@RequestBody Employee employee,@PathVariable Long id){
        employeeService.updateById(id,employee);

        return "updated Successfully";
    }
}
