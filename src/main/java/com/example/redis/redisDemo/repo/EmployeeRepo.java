package com.example.redis.redisDemo.repo;

import com.example.redis.redisDemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepo  extends JpaRepository<Employee, Long> {
    @Query("SELECT e FROM Employee e")
    List<Employee> findAllEmployees();
}
