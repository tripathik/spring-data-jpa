package com.intelliguru.springdatajpa.service;

import com.intelliguru.springdatajpa.entity.Employee;
import com.intelliguru.springdatajpa.exception.EmployeeNotFoundException;
import com.intelliguru.springdatajpa.exception.SqlDbException;
import com.intelliguru.springdatajpa.model.RequestPayload;
import com.intelliguru.springdatajpa.repository.EmployeeRepository;
import com.intelliguru.springdatajpa.validator.ValidatorUtil;
import com.intelliguru.springdatajpa.validator.exchange.ValidationErrorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployee() throws SqlDbException {
        try {
            return employeeRepository.findAll();
        } catch (Exception e) {
            throw new SqlDbException(e.getMessage());
        }
    }
    public Employee saveEmployee(Employee employee) throws SqlDbException {
        try {
            return employeeRepository.save(employee);
        } catch (Exception e) {
            throw new SqlDbException(e.getMessage());
        }
    }
    public Employee getEmployeeById(int employeeId) throws EmployeeNotFoundException {
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with ID: " + employeeId));
    }
    public void updateEmployeeById(int employeeId, Employee employeeData) throws EmployeeNotFoundException, SqlDbException {
        try {
            Employee employee = employeeRepository.findById(employeeId).orElse(null);
            if(employee != null){
                employee.setEmployeeName(employeeData.getEmployeeName());
                employee.setDepartment(employeeData.getDepartment());
                employee.setSalary(employeeData.getSalary());
                employee.setBonus(employeeData.getBonus());
                employeeRepository.save(employee);
            }else {
                throw new EmployeeNotFoundException("Employee not found with ID: " + employeeId);
            }
        } catch (EmployeeNotFoundException e) {
            throw new SqlDbException(e.getMessage());
        }
    }
    public void deleteEmployeeById(int employeeId){
        employeeRepository.deleteById(employeeId);
    }
    public void deleteAllEmployee(){
        employeeRepository.deleteAll();
    }

    public List<ValidationErrorDTO> getValidationErrorList(RequestPayload requestPayload) throws IOException {
        List<ValidationErrorDTO> validationErrorList = new ArrayList<>();
        Set<ConstraintViolation<RequestPayload>> constraintViolations = ValidatorUtil.getValidator().validate(requestPayload);
        if(!constraintViolations.isEmpty()){
            for(ConstraintViolation<RequestPayload> violation: constraintViolations){
                validationErrorList.add(new ValidationErrorDTO(violation.getMessage(), violation.getPropertyPath().toString()));
            }
        }
        try {
            if(!requestPayload.getData().getEntity().equalsIgnoreCase("some_data")){
                validationErrorList.add(new ValidationErrorDTO("Invalid Entity","data.entity"));
            }
        }catch (Exception e){
            throw new IOException("Invalid Json Format");
        }
        return validationErrorList;
    }
}
