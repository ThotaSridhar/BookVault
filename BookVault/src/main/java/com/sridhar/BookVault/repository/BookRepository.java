package com.sridhar.BookVault.repository;

import com.sridhar.BookVault.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
    public Book findByName(String name);
}
