package utils;

public class Validation {

    public boolean emailValidation(String email){
        boolean emailValidator = false;
        if(email.contains("@")){
            emailValidator = true;
        }
        return emailValidator;
    }

    public boolean passwordValidation(String password){
        boolean passwordValidator = false;
        if(password != null && password.length() > 6){
            passwordValidator = true;
        }
        return passwordValidator;
    }

}
