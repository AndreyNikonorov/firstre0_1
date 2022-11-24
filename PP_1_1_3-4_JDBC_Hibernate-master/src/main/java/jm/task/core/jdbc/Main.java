package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import org.postgresql.Driver;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
//        userService.createUsersTable();
//        userService.saveUser("Vasily", "Petrov", (byte) 25);
//        userService.saveUser("Ivan", "Pushkin", (byte) 25);
//        userService.saveUser("Sergey", "Sergeev", (byte) 25);
//        userService.saveUser("Alexander", "Nevsky", (byte) 25);
//        userService.saveUser("dmitry", "Platonov", (byte) 25);
//
//        List<User> userList = new ArrayList<>();
//        userList =  userService.getAllUsers();
//        for(User user : userList){
//            System.out.println(user.toString());
//        }
//        userService.removeUserById(4);
//        userService.removeUserById(12);
//        userService.removeUserById(22);
          userService.dropUsersTable();




        // реализуйте алгоритм здесь
    }
}
