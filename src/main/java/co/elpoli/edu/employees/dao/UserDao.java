package co.elpoli.edu.employees.dao;

import co.elpoli.edu.employees.models.User;

import java.util.List;

public interface UserDao {
    List<User> getUsers();

    User getUser(int id);

    User createUser(User user);

    User updateUser(int id, User employee);

    User deleteUser(int id);

    public interface EmployeeDao {
        List<User> getUsers();

        User getUser(int id);

        User createUser(User user);

        User updateUser(int id, User user);

        User deleteUser(int id);
    }
}
