package co.elpoli.edu.employees.dao;

import co.elpoli.edu.employees.models.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

@Repository
@Transactional
public class UsersImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getUsers() {
        String query = "FROM User";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User createUser(User user) {
        return entityManager.merge(user);
    }

    @Override
    public User updateUser(int id, User employee) {
        employee.setId(id);
        return entityManager.merge(employee);
    }

    @Override
    public User deleteUser(int id){
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
        return user;
    }
}
