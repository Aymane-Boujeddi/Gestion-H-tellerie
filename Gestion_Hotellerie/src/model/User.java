package model;
 
import java.util.UUID;

public class User {
   private String id;
   private String name;
   private String lastname;
   private String email;
   private String role;

    public User (String name , String lastname,String email,String role){
        this.name = name;
        this.lastname = lastname;
        this.email = email ;
        this.role = role ;
        UUID uuid = UUID.randomUUID();
        this.id= uuid.toString();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
