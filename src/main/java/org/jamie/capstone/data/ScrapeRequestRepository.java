package org.jamie.capstone.data;

import org.jamie.capstone.models.ScrapeRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScrapeRequestRepository extends CrudRepository<ScrapeRequest, Integer> {
}
