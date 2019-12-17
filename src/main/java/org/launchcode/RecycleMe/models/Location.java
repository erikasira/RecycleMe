package org.launchcode.RecycleMe.models;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


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
    @Size(message = "Please enter a city.")
    private String nameCity;

    @NotNull
    @Size(max=2, message = "Please enter a state.")
    private String nameState;




//    @ManyToOne
//    private City city;



    public Location(String locationName, String streetAddress ) {
        this.locationName = locationName;
        this.streetAddress = streetAddress;
        this.nameCity = nameCity;
        this.nameState = nameState;
    }


    public Location() {}

//    public City getCity() {
//        return city;
//    }
//    public void setCity(City cat) {
//        this.city = city;
//    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) { this.locationName = locationName; }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) { this.streetAddress = streetAddress; }

    public String getNameCity() {
        return nameCity;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }

    public String getNameState() {
        return nameState;
    }

    public void setNameState(String nameState) {
        this.nameState = nameState;
    }
}
