package com.example.EmployeeRestWebService.controller;

import com.example.EmployeeRestWebService.Exception_Handler.EmployeeNotFound;
import com.example.EmployeeRestWebService.model.Emoplyee;
import com.example.EmployeeRestWebService.model.EmployeeData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
public class EmployeeController {

    @Autowired
    EmployeeData service;

    @GetMapping("/Employee")// getting all the details of the employee
    public List<Emoplyee> getData()
    {
        return service.getAllEmployeeData();
    }

    @GetMapping("/Employee/{empId}")
    public  Emoplyee getEmployeeId(@PathVariable int empId)//getting the details of the employee by using the Id
    {
    Emoplyee emp=service.getEmployeeId(empId);
    if(null== emp)
        throw new EmployeeNotFound("Employee Not Found");
    return  emp;
    }



    @PostMapping("/Employee/user")//adding new employee data
    public ResponseEntity<Emoplyee> SaveEmployee(@RequestBody Emoplyee emp)
    {
       Emoplyee newEmployee= service.SaveEmployee(emp);
       URI uri= ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{employeeId")
                .buildAndExpand(newEmployee.getEmployeeId()).toUri();
       return  ResponseEntity.created(uri).build();
    }


  @PostMapping("/saveList") // adding list of employees data
public List<Emoplyee> saveListOfEmployees(@RequestBody List<Emoplyee> employees) {
    return service.SaveListOfEmployee(employees);
}

    @DeleteMapping("/Employee/Delete/{empId}")
    public void deleteEmployee(@PathVariable int empId)
    {

        Emoplyee emp=service.deleteEmployee(empId);
        if(null== emp)
            throw new EmployeeNotFound("Employee Not Found");
    }



}
