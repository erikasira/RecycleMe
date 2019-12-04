package org.launchcode.RecycleMe.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User {
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min= 5, max= 15)
    private String username;


    @NotNull
    @Size(min=5, message = "Password must be at least 5 characters long")
    private String password;

    //   It wont create a column in the database but will still verify the password
    @Transient
    @NotNull(message = "Passwords do not match")
    private String verifyPassword;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

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
    }

    private void checkPassword(){
        if (password != null && verifyPassword != null && !password.equals(verifyPassword)) {
            verifyPassword = null;
        }
    }
}
