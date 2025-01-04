package com.intelliguru.springdatajpa.controller;

import com.intelliguru.springdatajpa.entity.Employee;
import com.intelliguru.springdatajpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.intelliguru.springdatajpa.utils.constants.Constants.SOME_ERROR_OCCURRED;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;
    
    @GetMapping
    public ResponseEntity<?> getAllEmployees(){
        try {
            List<Employee> employeeList = employeeService.getAllEmployee();
            if(!employeeList.isEmpty()){
                return  new ResponseEntity<>(employeeList ,HttpStatus.OK);
            }
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(SOME_ERROR_OCCURRED, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{employeeId}")
    public ResponseEntity<?> getEmployeeById(@PathVariable int employeeId){
        try {
            Employee employeeList = employeeService.getEmployeeById(employeeId);
            if(employeeList != null){
                return  new ResponseEntity<>(employeeList ,HttpStatus.OK);
            }
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(SOME_ERROR_OCCURRED, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/{employeeId}")
    public ResponseEntity<?> updateEmployee(@PathVariable int employeeId, @RequestBody Employee employee){
        try {
            employeeService.updateEmployeeById(employeeId, employee);
            return  new ResponseEntity<>("Employee details have been updated successfully!!", HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(SOME_ERROR_OCCURRED, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/{employeeId}")
    public ResponseEntity<?> deleteEmployeeById(@PathVariable int employeeId){
        try {
            employeeService.deleteEmployeeById(employeeId);
            return  new ResponseEntity<>("Employee details have been deleted successfully!!", HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(SOME_ERROR_OCCURRED, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping()
    public ResponseEntity<?> deleteAllEmployee(){
        try {
            employeeService.deleteAllEmployee();
            return  new ResponseEntity<>("All the employees deleted successfully!!", HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(SOME_ERROR_OCCURRED, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping
    public ResponseEntity<?> saveEmployee(@RequestBody Employee employee){
        try {
            Employee savedEmployee = employeeService.saveEmployee(employee);
            return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(SOME_ERROR_OCCURRED, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
