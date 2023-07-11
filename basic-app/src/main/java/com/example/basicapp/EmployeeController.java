package com.example.basicapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService empser;

    @GetMapping()
    public EmployeeService getEmployee()
    {
        return empser;
    }


    @PostMapping("/save")
    public String addEmployee(@RequestBody Employee emp)
    {
        return empser.saveEmployee(emp);
    }

    @PutMapping
    public String insertEmployee(){
        return " insert employee was called";
    }

    @DeleteMapping("/dete/{id}")
    public String deleteEmployee(@PathVariable ("id") int id){
        empser.deleteEmployee(id);
        return "item is deleted";

    }
}
