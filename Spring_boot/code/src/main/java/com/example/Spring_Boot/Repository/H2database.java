package com.example.Spring_Boot.Repository;

import com.example.Spring_Boot.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//@Repository
public interface H2database extends JpaRepository<Employee,Integer> {
}
