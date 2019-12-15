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
    @GeneratedValue
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

//    private String status;
//-----the following was taken from Ni's code--not currently working
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "user_location", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "location_id"))
//    private Set<Role> roles;
//------------------------------------------------------------------------------------



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

//    public Set<Role> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(Set<Role> roles) {
//        this.roles = roles;
////    }
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }

    private void checkPassword(){
        if (password != null && verifyPassword != null && !password.equals(verifyPassword)) {
            verifyPassword = null;
        }


    }


}
