package org.launchcode.RecycleMe.models.data;

import org.launchcode.RecycleMe.models.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface CityDao extends CrudRepository<City, Integer> {


    City findById(int cityId);

}
