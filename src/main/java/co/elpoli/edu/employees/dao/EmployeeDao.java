package co.elpoli.edu.employees.dao;

import co.elpoli.edu.employees.models.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> getemployees();

    Employee getEmployee(int id);

    Employee createEmployee(Employee employee);

    Employee updateEmployee(int id, Employee employee);

    Employee deleteEmployee(int id);
}
