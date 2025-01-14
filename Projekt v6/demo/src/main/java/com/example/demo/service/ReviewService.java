package com.example.demo.service;

import com.example.demo.model.Review;
import com.example.demo.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    // Pobierz wszystkie recenzje
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    // Dodaj nową recenzję
    public Review addReview(Review review) {
        return reviewRepository.save(review);
    }
}