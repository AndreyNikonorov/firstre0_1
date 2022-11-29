import jm.core.jdbc.model.User;
import jm.core.jdbc.service.UserServiceImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;


public class UserServiceTest {
    private final UserServiceImpl userService = new UserServiceImpl();
    private final String name = "tester";
    private final String lastname = "testerov";
    private final byte age = 15;


    @Test
    public void dropUsersTableTest() {
        try {
            userService.dropUsersTable();
            userService.dropUsersTable();
        } catch (Exception e) {
            Assert.fail("error while dropping table");
        }
    }

    @Test
    public void createUsersTableTest() {
        try {
            userService.dropUsersTable();
            userService.createUsersTable();
        } catch (Exception e) {
            Assert.fail("error creating table");
        }
    }

    @Test
    public void saveUserTest() {

        try {
            userService.dropUsersTable();
            userService.createUsersTable();
            userService.saveUser(name, lastname, age);
            User user = userService.getAllUsers().get(0);
            if (!user.getName().equals(name) || !user.getLastName().equals(lastname)
                    || user.getAge()!=age) {
                System.out.println(user.getName());
                System.out.println(user.getLastName());
                System.out.println(user.getAge());
                Assert.fail("incorrect added user");
            }
        } catch (Exception e) {
            Assert.fail("не удвлось добавить пользователя");
        }

    }

    @Test
    public void deleteUserById(){
        try{
            userService.dropUsersTable();
            userService.createUsersTable();
            userService.saveUser(name,lastname,age);
            userService.removeUserById(1);

        }catch(Exception e){
            Assert.fail("delete user failed");
        }
    }
    @Test
    public void cleanUsersTable(){
        try{
            userService.dropUsersTable();
            userService.createUsersTable();
            userService.saveUser(name,lastname,age);
            userService.saveUser(name,lastname,age);
            userService.cleanUsersTable();
            if(userService.getAllUsers().size() !=0){
                Assert.fail("table clean failed");
            }

        }catch(Exception e){
            Assert.fail("clean failed");
        }
    }
    @Test
    public void getAllUsers() {
        try {
            userService.dropUsersTable();
            userService.createUsersTable();
            userService.saveUser(name, lastname, age);
            List<User> userList = userService.getAllUsers();

            if (userList.size() != 1) {
                Assert.fail("get all users failed");
            }
        } catch (Exception e) {
            Assert.fail("common fail");
        }

    }
}



