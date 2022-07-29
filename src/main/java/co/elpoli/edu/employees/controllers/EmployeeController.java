package co.elpoli.edu.employees.controllers;
import co.elpoli.edu.employees.dao.EmployeeDao;
import co.elpoli.edu.employees.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping(value = "test")
    public String test(){
        return "Hola Spring boot";
    }

    @RequestMapping(value = "api/employees", method = RequestMethod.GET)
    public List<Employee> getemployees(){
        return employeeDao.getemployees();
    }

    @RequestMapping(value = "api/employee/{id}", method = RequestMethod.GET)
    public Employee getEmployee(@PathVariable("id") int id){
        return employeeDao.getEmployee(id);
    }

    @RequestMapping(value = "api/employee", method = RequestMethod.POST)
    public Employee insertEmployee(@RequestBody Employee e){
        return employeeDao.createEmployee(e);
    }

    @RequestMapping(value = "api/employee/{id}", method = RequestMethod.PUT)
    public Employee updateEmployee(@PathVariable("id") int id, @RequestBody Employee e){
        return employeeDao.updateEmployee(id, e);
    }

    @RequestMapping(value = "api/employee/{id}", method = RequestMethod.DELETE)
    public Employee deleteEmployee(@PathVariable("id") int id){
        return employeeDao.deleteEmployee(id);
    }

}
