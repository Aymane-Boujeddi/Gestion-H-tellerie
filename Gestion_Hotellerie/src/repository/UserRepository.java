package repository;

import entity.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;



interface UserRepository {

void addUser(User user);
User findByEmail(String email);
public Collection<User> allUsers();
public String getUserID(String name);
Boolean emailExisting(String email);
public void updateUserPassword(User user,String password);
public void updateUserName(User user,String name);
public void updateUserLastName(User user,String lastname);
public void updateUserEmail(User user,String email);

}