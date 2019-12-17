package org.launchcode.RecycleMe.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Resource {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(message = "Please enter the name of the website.")
    private String name;

    @NotNull
    @Size(message = "Please enter the link to the website.")
    private String link;



    public Resource(String name, String link) {

        this.name = name;
        this.link = link;
    }

    public Resource() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
