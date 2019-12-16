package org.launchcode.RecycleMe.models;


import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @NotNull
    @Size(min= 5, max= 15, message = "Username must be between 5 and 15 characters")
    private String username;


    @NotNull
    @Size(min=5, message = "Password must be at least 5 characters long")
    private String password;

    @Transient
    @NotNull(message = "Passwords do not match")
    private String verifyPassword;



    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {

        this.password = password;
        checkPassword();
    }

    public String getVerifyPassword() { return verifyPassword; }

    public void setVerifyPassword(String verifyPassword) {

        this.verifyPassword = verifyPassword;
        checkPassword();
    }


    private void checkPassword(){
        if (password != null && verifyPassword != null && !password.equals(verifyPassword)) {
            verifyPassword = null;
        }


    }


}
