package com.example.demo.controller;


import com.example.demo.model.Review;
import com.example.demo.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewRepository reviewRepository;

    @GetMapping("/user/{userId}")
    public List<Review> getReviewsByUserId(@PathVariable Long userId) {
        return reviewRepository.findByUserId(userId);
    }

    @PostMapping
    public Review createReview(@RequestBody Review review) {
        return reviewRepository.save(review);
    }

    @DeleteMapping("/{bookId}")
    public String deleteReviewsByBookId(@PathVariable Long bookId) {
        reviewRepository.deleteByBookId(bookId);
        return "Usunięto recenzje dla książki o ID: " + bookId;
    }
}