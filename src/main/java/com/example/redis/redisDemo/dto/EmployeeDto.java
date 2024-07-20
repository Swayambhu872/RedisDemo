package com.example.redis.redisDemo.dto;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class EmployeeDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private long empId;
    private String name;
    private String department;
    private int age;
    private int salary;
}
