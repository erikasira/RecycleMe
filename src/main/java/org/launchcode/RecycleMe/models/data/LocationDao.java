package org.launchcode.RecycleMe.models.data;

import org.launchcode.RecycleMe.models.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface LocationDao extends CrudRepository<Location, Integer> {
    Location findByUser(String user);

}
