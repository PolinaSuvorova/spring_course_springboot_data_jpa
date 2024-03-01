package com.polina.spring.springboot.spring_course_springboot_data_jpa.controller;


import com.polina.spring.springboot.spring_course_springboot_data_jpa.entity.Employee;
import com.polina.spring.springboot.spring_course_springboot_data_jpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable("id") int id) {
        return employeeService.getEmployee(id);
    }
    @GetMapping("/employees/name/{name}")
    public List<Employee> getEmployeeByName(@PathVariable("name") String name) {
        return employeeService.findAllByName(name);
    }
    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable("id") int id) {
        employeeService.deleteEmployee(id);
        return "Employee with id " + id + " was deleted";
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }
}
