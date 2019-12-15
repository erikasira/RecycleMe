package org.launchcode.RecycleMe.models;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


@Entity
public class Location {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private int cityId;

    @NotNull
    @Size(message = "Please enter a location name.")
    private String locationName;


    @NotNull
    @Size(message = "Please enter a Street Address.")
    private String streetAddress;

//    @ManyToOne
//    private City city;



//    @NotNull
//    @Size(message = "Please enter a City.")
//    private String cityName;
//
//    @NotNull
//    @Size(message = "Please enter a State.")
//    private String state;


//    @ManyToMany(mappedBy = "locations")
//    private List<City> cities;


    public Location(String locationName, String streetAddress, String cityName, String state) {
        this.locationName = locationName;
        this.streetAddress = streetAddress;
//        this.cityName = cityName;
//        this.state = state;
    }


    public Location() {}

//    public City getCity() {
//        return city;
//    }
//
//    public void setCity(City city) {
//        this.city = city;
//    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) { this.locationName = locationName; }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) { this.streetAddress = streetAddress; }

//    public String getCityName() {
//        return cityName;
//    }
//
//    public void setCityName(String cityName) {
//        this.cityName = cityName;
//    }
//
//    public String getState() { return state; }
//
//    public void setState(String state) { this.state = state; }

    public int getCityId() {
        return cityId;
    }


    public void setCity(City cat) {
    }
}
