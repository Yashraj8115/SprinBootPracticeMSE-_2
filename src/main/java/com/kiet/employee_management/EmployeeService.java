package com.kiet.employee_management;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final List<Employee> employees = new ArrayList<>();

    public EmployeeService() {
        employees.add(new Employee(1, "Rahul", "IT", 50000));
        employees.add(new Employee(2, "Priya", "HR", 45000));
    }

    // Get all employees
    public List<Employee> getAllEmployees() {
        return employees;
    }

    // Get employee by ID
    public Employee getEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    // Add a new employee
    public Employee addEmployee(Employee employee) {
        employees.add(employee);
        return employee;
    }

    // Update an employee
    public Employee updateEmployee(int id, Employee updatedEmployee) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == id) {
                updatedEmployee.setId(id);
                employees.set(i, updatedEmployee);
                return updatedEmployee;
            }
        }
        return null;
    }

    // Delete an employee
    public boolean deleteEmployee(int id) {
        return employees.removeIf(employee -> employee.getId() == id);
    }
}