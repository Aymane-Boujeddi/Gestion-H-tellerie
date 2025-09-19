package repository;

import entity.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class InMemoryUserRepository  implements  UserRepository{

    Map<String, User>  users = new HashMap<>();
    public InMemoryUserRepository(){
        User admin = new User("admin","admin","admin","admin","1");
        users.put(admin.getEmail(),admin);
    }
    @Override
    public void addUser(User user) {
        String email = user.getEmail();
        users.put(email, user);
    }

    @Override
    public User findByEmail(String email) {
       return    users.get(email);

    }


    @Override
    public Boolean emailExisting(String email) {

        return users.containsKey(email);
    }

    @Override
    public void updateUserPassword(User user, String password) {

    }

    @Override
    public void updateUserName(User user, String name) {

    }

    @Override
    public void updateUserLastName(User user, String lastname) {

    }

    @Override
    public void updateUserEmail(User user, String email) {

    }

    public Collection<User> allUsers(){
        return users.values();

    }

    @Override
    public String getUserID(String name) {
        return users.get(name).getId();
    }
}
