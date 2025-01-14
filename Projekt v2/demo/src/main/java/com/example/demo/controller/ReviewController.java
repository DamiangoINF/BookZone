package com.example.demo.controller;


import com.example.demo.model.Review;
import com.example.demo.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewRepository reviewRepository;

    @GetMapping("/user/{userId}")
    public List<Review> getReviewsByUserId(@PathVariable Long userId) {
        return reviewRepository.findByUserId(userId);
    }

    @PostMapping
    public Review addReview(@RequestBody Review review) {
        return reviewRepository.save(review);
    }

    @DeleteMapping("/{bookId}")
    public String deleteReviewsByBookId(@PathVariable Long bookId) {
        reviewRepository.deleteByBookId(bookId);
        return "Recenzje usunięte dla książki o ID: " + bookId;
    }
}