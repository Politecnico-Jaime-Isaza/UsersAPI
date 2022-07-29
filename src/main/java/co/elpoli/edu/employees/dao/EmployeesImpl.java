package co.elpoli.edu.employees.dao;

import co.elpoli.edu.employees.models.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

@Repository
@Transactional
public class EmployeesImpl implements EmployeeDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Employee> getemployees() {
        String query = "FROM Employee";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Employee getEmployee(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return entityManager.merge(employee);
    }

    @Override
    public Employee updateEmployee(int id, Employee employee) {
        employee.setId(id);
        return entityManager.merge(employee);
    }

    @Override
    public Employee deleteEmployee(int id){
        Employee e = entityManager.find(Employee.class, id);
        entityManager.remove(e);
        return e;
    }
}
