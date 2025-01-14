package com.example.demo.repository;

import com.example.demo.model.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChallengeRepository extends JpaRepository<Challenge, Long> {
    // Możemy dodać metody specyficzne dla wyzwań, jeśli będą potrzebne
}