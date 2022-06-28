package com.moseswilliams.spring1webapp.repos;

import com.moseswilliams.spring1webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepo extends CrudRepository<Author, Long>{
}
