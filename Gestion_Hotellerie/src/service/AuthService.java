package service;

import entity.User;
import repository.InMemoryUserRepository;


public class AuthService {
    private final InMemoryUserRepository inMemoryUserRepository ;

    public AuthService(InMemoryUserRepository inMemoryUserRepository){
        this.inMemoryUserRepository = inMemoryUserRepository;
    }


    public  boolean login(String email,String password){
        boolean loginStatus = false;
            if(this.inMemoryUserRepository.emailExisting(email)){
                User user = this.inMemoryUserRepository.findByEmail(email);
                if(user.getPassword().equals(password)){
                    loginStatus = true;
                }
            }
            return loginStatus;
    }
    public  boolean register(String name,String email,String password,String lastname,String role){

        if(!this.inMemoryUserRepository.emailExisting(email)){
        User user = new User(name,lastname,email,role,password);
        inMemoryUserRepository.addUser(user);
        return true;


        }else{
            return false;
        }
    }
    public User getCurrentUser(String email){
        return inMemoryUserRepository.findByEmail(email);
    }
}