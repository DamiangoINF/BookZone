package com.example.demo.service;

import com.example.demo.model.Challenge;
import com.example.demo.repository.ChallengeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChallengeService {

    @Autowired
    private ChallengeRepository challengeRepository;

    // Ustaw lub zaktualizuj cel wyzwania
    public Challenge setChallenge(int goal) {
        Optional<Challenge> existingChallenge = challengeRepository.findById(1L); // Zakładamy, że jest tylko jedno wyzwanie

        if (existingChallenge.isPresent()) {
            // Jeśli wyzwanie istnieje, zaktualizuj je
            Challenge challenge = existingChallenge.get();
            challenge.setGoal(goal);
            return challengeRepository.save(challenge);
        } else {
            // Jeśli wyzwanie nie istnieje, utwórz nowe
            Challenge challenge = new Challenge();
            challenge.setGoal(goal);
            challenge.setBooksRead(0);
            return challengeRepository.save(challenge);
        }
    }

    // Pobierz wyzwanie
    public Optional<Challenge> getChallenge() {
        return challengeRepository.findById(1L); // Zakładamy, że jest tylko jedno wyzwanie
    }

    // Dodaj przeczytane książki do wyzwania
    public Challenge addBooksRead(int booksRead) {
        Optional<Challenge> existingChallenge = challengeRepository.findById(1L); // Zakładamy, że jest tylko jedno wyzwanie

        if (existingChallenge.isPresent()) {
            Challenge challenge = existingChallenge.get();
            challenge.setBooksRead(challenge.getBooksRead() + booksRead);
            return challengeRepository.save(challenge);
        } else {
            throw new RuntimeException("Wyzwanie nie znalezione.");
        }
    }
}