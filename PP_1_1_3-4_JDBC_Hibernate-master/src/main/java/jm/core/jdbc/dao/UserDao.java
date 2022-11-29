package jm.core.jdbc.dao;

import jm.core.jdbc.model.User;

import java.util.List;

public interface UserDao {
    void createUsersTable();

    void dropUsersTable();

    void saveUser(String name, String lastName, byte age);

    void removeUserById(int id);

    List<User> getAllUsers();

    void cleanUsersTable();
}
