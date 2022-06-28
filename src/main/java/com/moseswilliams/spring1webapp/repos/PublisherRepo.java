package com.moseswilliams.spring1webapp.repos;

import com.moseswilliams.spring1webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepo extends CrudRepository<Publisher, Long> {
}
