package com.example.redis.redisDemo.mapper;

import com.example.redis.redisDemo.dto.EmployeeDto;
import com.example.redis.redisDemo.entity.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeDto mapToEmployee(Employee employee);
}
