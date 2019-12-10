package org.launchcode.RecycleMe.models.forms;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;


@Entity
public class Location {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(message = "Please enter a location name.")
    private String locationName;


    @NotNull
    @Size(message = "Please enter a Street Address.")
    private String streetAddress;

    @NotNull
    @Size(message = "Please enter a City.")
    private String city;

    @NotNull
    @Size(message = "Please enter a State.")
    private String state;

    @ManyToOne
    private User user;

    public Location(String locationName, String streetAddress, String city, String state) {
        this.locationName = locationName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
    }


    public Location() {}
    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) { this.locationName = locationName; }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) { this.streetAddress = streetAddress; }

    public String getCity() {
        return city;
    }

    public void setCity(String city) { this.city = city; }

    public String getState() { return state; }

    public void setState(String state) { this.state = state; }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
