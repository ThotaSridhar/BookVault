package com.sridhar.BookVault.service.impl;

import com.sridhar.BookVault.domain.Book;
import com.sridhar.BookVault.repository.BookRepository;
import com.sridhar.BookVault.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;


@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;
    @Override
    public Book addbook(Book book) {
        Book book1 = bookRepository.save(book);
        return book1;
    }

    @Override
    public void deleteBook(Integer id) {
        Optional<Book> book = bookRepository.findById(id);
        if(book.isPresent()){
            bookRepository.delete(book.get());
        }
    }

    @Override
    public Book updateBook(Book book, Integer id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        Book book1 = bookOptional.get();
        if(book1==null){
            return null;
        }
        book1.setAuthor(book.getAuthor());
        book1.setCost(book.getCost());
        book1.setName(book.getName());
        book1.setYear(book.getYear());
        book1.setGenre(book.getGenre());
        bookRepository.save(book1);
        return book1;
    }

    @Override
    public Book getBook(Integer id) {
        Optional<Book> book = bookRepository.findById(id);
        if(book.isPresent()){
            return book.get();
        }
        return null;
    }

    @Override
    public Book findByName(String name){
        Book book = bookRepository.findByName(name);
        return book;
    }
    @Override
    public List<Book> getBooks() {
        List<Book> books = bookRepository.findAll();
        return books;
    }
}
