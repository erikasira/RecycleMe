package org.launchcode.RecycleMe.models.data;

import org.launchcode.RecycleMe.models.Resource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface ResourceDao extends CrudRepository<Resource, Integer> {
    Resource findById(int cityId);

}
