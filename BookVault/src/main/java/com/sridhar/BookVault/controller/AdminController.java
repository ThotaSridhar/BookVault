package com.sridhar.BookVault.controller;

import com.sridhar.BookVault.domain.Book;
import com.sridhar.BookVault.service.BookService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {

    @Autowired
    BookService bookService;
    @PostMapping("/admin")
    public ResponseEntity<?> addBook(@RequestBody Book book){
       Book book1 =  bookService.addbook(book);
       return new ResponseEntity<>(book1, HttpStatus.CREATED);
    }
    @PutMapping("/admin/{id}")
    public ResponseEntity<?> updateBook(@RequestBody Book book, @PathVariable("id") Integer id){
        Book book1 = bookService.updateBook(book,id);
        if(book1==null){
            return new ResponseEntity<>("Book not found",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(book1,HttpStatus.OK);
    }
    @DeleteMapping("/admin")
    public ResponseEntity<?> deleteBook(@RequestParam("id") Integer id){
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
