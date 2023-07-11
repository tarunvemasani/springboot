package com.example.basicapp;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    List<Employee> emp = new ArrayList<Employee>();
    public EmployeeService(){
        emp.add(new Employee(1,"tarun"));
        emp.add(new Employee(2,"varun"));
        emp.add(new Employee(3,"arun"));
    }

    public List<Employee> getEmployee(){
        return emp;
    }

    public String saveEmployee(Employee e){
        emp.add(e);
        return "Item is added";
    }

    public String deleteEmployee(int id){
        emp.remove(id);
        return "object is removed";
    }




}
