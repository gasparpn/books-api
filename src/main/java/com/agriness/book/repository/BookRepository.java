package com.agriness.book.repository;

import com.agriness.book.entity.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {

    List<Book> findBookByClientId(Long clientId);
}
