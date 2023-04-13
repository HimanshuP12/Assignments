package com.restfulPart1.assignment.restfulwebservicepart1.Controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.restfulPart1.assignment.restfulwebservicepart1.Employee.*;
import com.restfulPart1.assignment.restfulwebservicepart1.Exception.ResourceNotFound;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;


@RestController
public class Controller {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    UserService userService;

    @Operation(summary = "To print Hello World on web", description = " Printing hello world using spring boot application.")
    @GetMapping("/Ques1")
    public String returnWelcomeMsg(){
        return "Welcome to spring boot";
    }

    @Operation(summary = "To get all the list of employees")
    @GetMapping("/employees")
    public List<Employee> retrieveAllEmployees(){
        return employeeService.findAll();
    }

    @Operation(summary = "Get a employee by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode ="200",description="Successfully Executed"),
            @ApiResponse(responseCode = "404",description = "Id not present")
    })
    @GetMapping("/employees/{id}")
    public EntityModel<Employee> retrieveSingleEmployee(@PathVariable Long id){
        Employee emp=employeeService.findById(id);
        if(emp==null){
            throw new ResourceNotFound("ID: "+id);
        }
        EntityModel<Employee> entityModel=EntityModel.of(emp);
        WebMvcLinkBuilder link= WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllEmployees());
        entityModel.add(link.withRel("All-Employees"));

        return entityModel;
    }

    @Operation(summary = "To create a new employee Entry")
    @ApiResponses(value = {
            @ApiResponse(responseCode ="200",description="Successfully Created")
    })
    @PostMapping("/employees")
    public String createUser(@Valid @RequestBody Employee employee){
        employeeService.addEmployee(employee);
        return "Created Successfully";
    }

    @Operation(summary = "To delete an employee using ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode ="200",description="Successfully Deleted"),
            @ApiResponse(responseCode = "404",description = "Id not present")
    })
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id){
        employeeService.deleteById(id);
        return "Employee Deleted Successfully";
    }

    @Operation(summary = "Update the details of an employee using ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode ="200",description="Successfully Executed"),
            @ApiResponse(responseCode = "404",description = "Id not present")
    })
    @PutMapping("/put/{id}")
    public String updateEmployeeDetails(@RequestBody Employee employee,@PathVariable Long id){
        employeeService.updateById(id,employee);

        return "updated Successfully";
    }

    @GetMapping("/v1/employees")
    public List<Employee> getFirstVersion(){
        return new EmployeeService().findAll();
    }

    @GetMapping("/v2/employees")
    public List<EmployeeV2> getSecondVersion(){
        return new EmployeeService().findAllV2();
    }

    @GetMapping(path = "/details",params = "version=1")
    public List<Employee> getFirstVersionUsingRequestParameter(){
        return new EmployeeService().findAll();
    }

    @GetMapping(path = "/details",params = "version=2")
    public List<EmployeeV2> getSecondVersionUsingRequestParameter(){
        return new EmployeeService().findAllV2();
    }

    @GetMapping(path = "details/header",headers= "api-version=1")
    public List<Employee> getFirstVersionUsingRequestHeaders(){
        return new EmployeeService().findAll();
    }

    @GetMapping(path = "/details/header",headers = "api-version=2")
    public List<EmployeeV2> getSecondVersionUsingRequestHeaders(){
        return new EmployeeService().findAllV2();
    }


    @GetMapping(path = "details/accept",produces= "application/vnd.company.app-v1+json")
    public List<Employee> getFirstVersionUsingRequestAcceptHeaders(){
        return new EmployeeService().findAll();
    }

    @GetMapping(path = "details/accept",produces= "application/vnd.company.app-v3+json")
    public List<EmployeeV2> getSecondVersionUsingRequestAcceptHeaders(){
        return new EmployeeService().findAllV2();
    }

    @GetMapping(path = "/users")
    public List<User> retrieveAllUser(){
        return userService.findAll();
    }

    @PostMapping("/users")
    public String createUser(@RequestBody User user){
        userService.addUser(user);
        return "Created Successfully";
    }

    @GetMapping(path = "/dynamic-filtering")
    public MappingJacksonValue retrieveSingleUser(){
        User user = userService.findAll().stream().findFirst().get();
        MappingJacksonValue mappingJacksonValue=new MappingJacksonValue(user);
        PropertyFilter filter= SimpleBeanPropertyFilter.filterOutAllExcept("userName","age","id");
        FilterProvider filters=new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }

    
    




}
