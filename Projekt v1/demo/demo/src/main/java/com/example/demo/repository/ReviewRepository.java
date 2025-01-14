package com.example.demo.repository;


import com.example.demo.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByUserId(Long userId);
    List<Review> findByBookId(Long bookId);

    // Dodaj tę metodę, aby usunąć recenzje na podstawie bookId
    void deleteByBookId(Long bookId);
}