package com.intelliguru.springdatajpa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;

    @NotNull(message = "Employee Name can not be null.")
    @NotBlank(message = "Employee is required.")
    private String employeeName;

    @NotEmpty(message = "Department can not be empty.")
    private String department;

    private double salary;
    private int bonus;

    @NotNull(message = "Age can not be null.")
    @Min(value = 18, message = "Minimum working age 18")
    @Max(value = 60, message = "Maximum working age 60")
    private Integer age;

    @Email(message = "Please enter a valid email Id")
    @NotNull(message = "Email cannot be NULL")
    private String userEmail;

    @NotNull(message = "Employee ID cannot be null")
    @Pattern(regexp = "EMP\\d{3}", message = "Employee Reference ID must follow the pattern EMP001")
    private String empReferenceId;
}
