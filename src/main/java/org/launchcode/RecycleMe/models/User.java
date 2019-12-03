package org.launchcode.RecycleMe.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
public class User {
    @Id
    @GeneratedValue
    private int id;
    @NotNull

    @Size(min=5, max=15)
    private String username;

    @NotNull
    @Size(min=6,max=15)
    private String password;
    @NotNull
    @Size(min=5, max=15)

    public int getId() {
        return id;
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

}
