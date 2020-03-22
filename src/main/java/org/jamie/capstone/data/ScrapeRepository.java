package org.jamie.capstone.data;


import org.jamie.capstone.models.ScrapeItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScrapeRepository extends CrudRepository<ScrapeItem, Integer> {
}
