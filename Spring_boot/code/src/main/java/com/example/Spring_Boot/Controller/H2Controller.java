package com.example.Spring_Boot.Controller;

import com.example.Spring_Boot.Model.Employee;
import com.example.Spring_Boot.Repository.H2database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class H2Controller {
    @Autowired
    H2database h2database;

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getEmployeeList(){
        try{
            List<Employee> employeeList = new ArrayList<Employee>();
            h2database.findAll().forEach(employeeList::add);

            if(employeeList.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(employeeList, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable int id){
        Optional<Employee> employee1 = h2database.findById(id);
        if(employee1.isPresent()){
            return new ResponseEntity<>(employee1.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping("/add")
    public ResponseEntity<Employee> saveEmployee( @RequestBody Employee employee){
        Employee employee1 = h2database.save(employee);
        return new ResponseEntity<>(employee1, HttpStatus.OK);

    }

    @PostMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee newEmployee){
        Optional<Employee> oldEmployee = h2database.findById(id);

        if(oldEmployee.isPresent()){
            Employee updatedEmployee = oldEmployee.get();
            updatedEmployee.setEmp_name(newEmployee.getEmp_name());
            updatedEmployee.setEmp_designation(newEmployee.getEmp_designation());

            return new ResponseEntity<>(h2database.save(updatedEmployee), HttpStatus.OK);
        }
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
