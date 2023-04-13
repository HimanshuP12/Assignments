package com.restfulPart1.assignment.restfulwebservicepart1.Employee;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class UserService {

    private static int id=0;
    private static List<User> list=new ArrayList<>();

    public List<User> findAll(){
        return list;
    }

    public User findById(Long id){
        return list.stream()
                .filter(employee -> employee.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public User addUser(User user){
        user.setId(++id);
        list.add(user);
        return user;
    }

    public void deleteById(Integer id){
        list.removeIf(employee -> employee.getId().equals(id));
    }

    public void updateById(Integer id,User user1){
        User user=list.stream()
                .filter(employee -> employee.getId().equals(id))
                .findFirst()
                .get();

        user.setUserName(user1.getUserName());
        user.setAge(user1.getAge());

    }
}
