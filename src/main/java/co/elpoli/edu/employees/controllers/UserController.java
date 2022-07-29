package co.elpoli.edu.employees.controllers;

import co.elpoli.edu.employees.dao.UserDao;
import co.elpoli.edu.employees.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "test")
    public String test(){
        return "Hola Spring boot";
    }

    @RequestMapping(value = "api/users", method = RequestMethod.GET)
    public List<User> getUsers(){
        return userDao.getUsers();
    }

    @RequestMapping(value = "api/user/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable("id") int id){
        return userDao.getUser(id);
    }

    @RequestMapping(value = "api/user", method = RequestMethod.POST)
    public User insertUser(@RequestBody User u){
        return userDao.createUser(u);
    }

    @RequestMapping(value = "api/user/{id}", method = RequestMethod.PUT)
    public User updateUser(@PathVariable("id") int id, @RequestBody User u){
        return userDao.updateUser(id, u);
    }

    @RequestMapping(value = "api/user/{id}", method = RequestMethod.DELETE)
    public User deleteUser(@PathVariable("id") int id){
        return userDao.deleteUser(id);
    }
}
