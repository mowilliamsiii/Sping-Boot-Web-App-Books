package com.moseswilliams.spring1webapp.repos;

import com.moseswilliams.spring1webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepo extends CrudRepository<Book, Long> {
}
