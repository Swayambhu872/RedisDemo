package com.example.redis.redisDemo.service;

import com.example.redis.redisDemo.dto.EmployeeDto;
import com.example.redis.redisDemo.entity.Employee;
import com.example.redis.redisDemo.mapper.EmployeeMapper;
import com.example.redis.redisDemo.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepo employeeRepo;

    //Field injection
    @Autowired
    private EmployeeMapper employeeMapper;


    //Constructor injection
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public List<Employee> getAllEmployee() {
        return employeeRepo.findAllEmployees();
    }

    @Cacheable(value = "employee", key ="#empId" )
    public EmployeeDto getEmployeeById(Long empId) {
        Employee employee = employeeRepo.getReferenceById(empId);
        EmployeeDto mappedEmployee = employeeMapper.mapToEmployee(employee);
        System.out.println(mappedEmployee);
        return mappedEmployee;
    }

    public void saveEmployee(Employee employee) {
        try {
            employeeRepo.save(employee);
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }
}
