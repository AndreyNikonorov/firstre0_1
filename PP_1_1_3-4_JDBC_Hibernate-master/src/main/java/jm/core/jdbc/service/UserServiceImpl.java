package jm.core.jdbc.service;

import jm.core.jdbc.dao.UserDaoHibernateImpl;
import jm.core.jdbc.dao.UserDaoJDBCImpl;
import jm.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDaoHibernateImpl userDaoJDBC = new UserDaoHibernateImpl();
    public void createUsersTable() {
    userDaoJDBC.createUsersTable();


    }

    public void dropUsersTable() {
        userDaoJDBC.dropUsersTable();

    }

    public void saveUser(String name, String lastName, byte age) {
        userDaoJDBC.saveUser(name,lastName,age);

    }

    public void removeUserById(long id) {
        userDaoJDBC.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return userDaoJDBC.getAllUsers();

    }

    public void cleanUsersTable() {
        userDaoJDBC.cleanUsersTable();

    }
}
