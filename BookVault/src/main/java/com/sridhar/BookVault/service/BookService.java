package com.sridhar.BookVault.service;


import com.sridhar.BookVault.domain.Book;

import java.util.List;

public interface BookService {
    public Book addbook(Book book);
    public void deleteBook(Integer id);
    public Book updateBook(Book book,Integer id);
    public Book getBook(Integer id);
    public List<Book> getBooks();

    public Book findByName(String name);
}
