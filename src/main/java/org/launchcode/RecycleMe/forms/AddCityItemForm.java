package org.launchcode.RecycleMe.forms;

import com.sun.tools.javac.file.Locations;
import org.launchcode.RecycleMe.models.City;
import org.launchcode.RecycleMe.models.Location;

import javax.validation.constraints.NotNull;

public class AddCityItemForm {


    private City city;

    private Iterable<Location> locations;

    @NotNull
    private int cityId;

    @NotNull
    private int locationId;

    public AddCityItemForm(City city, Iterable<Location> locations) {
        this.city = city;
        this.locations = locations;
    }

    public AddCityItemForm() {
    }

    public City getCity() {
        return city;
    }

    public Iterable<Location> getLocations() {
        return locations;
    }

    public int getCityId() {
        return cityId;
    }

    public int getLocationId() {
        return locationId;
    }
}

