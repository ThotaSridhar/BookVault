package com.sridhar.BookVault.service;

import com.sridhar.BookVault.domain.Book;
import com.sridhar.BookVault.domain.Review;

public interface ReviewService {
    public Book addReview(Review review,Integer book_id);
}
