package com.sridhar.BookVault.controller;

import com.sridhar.BookVault.domain.Book;
import com.sridhar.BookVault.domain.Review;
import com.sridhar.BookVault.domain.Users;
import com.sridhar.BookVault.service.BookService;
import com.sridhar.BookVault.service.ReviewService;
import com.sridhar.BookVault.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    BookService bookService;

    @Autowired
    ReviewService reviewService;

    @Autowired
    UserService userService;

    @PostMapping("/user/register")
    public ResponseEntity<?> register(@RequestBody Users user){
       Users user1 = userService.register(user);
       return new ResponseEntity<>(user1,HttpStatus.CREATED);
    }

    @PostMapping("/user/logging")
    public ResponseEntity<?> logging(@RequestBody Users user){
        String response  =  userService.logging(user);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getBook(@PathVariable("id") Integer id){
        Book book = bookService.getBook(id);
        if(book==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(book,HttpStatus.OK);
    }
    @GetMapping("user/ByName")
    public ResponseEntity<?> getBook(@RequestParam("name") String name){
        Book book = bookService.findByName(name);
        if(book==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(book,HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<?> getBooks(){
        List<Book> books = bookService.getBooks();
        if(books.size()==0) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(books,HttpStatus.OK);
    }

    @PostMapping("/user/review/{id}")
    public ResponseEntity<?> addReview(@RequestBody Review review, @PathVariable("id") Integer id){
         Book book =reviewService.addReview(review,id);
        return new ResponseEntity<>(book,HttpStatus.CREATED);
    }

}
