package com.sridhar.BookVault.service.impl;

import com.sridhar.BookVault.domain.Book;
import com.sridhar.BookVault.domain.Review;
import com.sridhar.BookVault.repository.BookRepository;
import com.sridhar.BookVault.repository.ReviewRepository;
import com.sridhar.BookVault.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    BookRepository bookRepository;
    @Override
    public Book addReview(Review review, Integer book_id) {
        Optional<Book> book = bookRepository.findById(book_id);
        if(!book.isPresent()){
            return null;
        }
        review.setBook(book.get());
        reviewRepository.save(review);
        return book.get();
    }
}
