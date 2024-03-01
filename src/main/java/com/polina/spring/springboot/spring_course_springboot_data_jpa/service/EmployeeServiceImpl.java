package com.polina.spring.springboot.spring_course_springboot_data_jpa.service;

import com.polina.spring.springboot.spring_course_springboot_data_jpa.repository.EmployeeRepository;
import com.polina.spring.springboot.spring_course_springboot_data_jpa.entity.Employee;
import com.polina.spring.springboot.spring_course_springboot_data_jpa.exception.NoSuchEmployeeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        int id = employee.getId();
        if (id != 0) {
            getEmployee(employee.getId());
        }
        employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        Optional<Employee> optional = employeeRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new NoSuchEmployeeException("No employee with " + id);
        }
    }

    @Override
    public void deleteEmployee(int id) {
        getEmployee(id);
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> findAllByName(String name) {
        return employeeRepository.findAllByName(name);
    }
}
