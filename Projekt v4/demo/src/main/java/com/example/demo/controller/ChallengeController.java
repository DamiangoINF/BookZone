package com.example.demo.controller;

import com.example.demo.model.AddBooksRequest;
import com.example.demo.model.Challenge;
import com.example.demo.model.ChallengeRequest;
import com.example.demo.service.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/challenge")
public class ChallengeController {

    @Autowired
    private ChallengeService challengeService;

    // Ustaw lub zaktualizuj cel wyzwania
    @PostMapping
    public ResponseEntity<Challenge> setChallenge(@RequestBody ChallengeRequest request) {
        Challenge challenge = challengeService.setChallenge(request.getGoal());
        return ResponseEntity.ok(challenge);
    }

    // Pobierz wyzwanie
    @GetMapping
    public ResponseEntity<Challenge> getChallenge() {
        Optional<Challenge> challenge = challengeService.getChallenge();

        if (challenge.isPresent()) {
            return ResponseEntity.ok(challenge.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Dodaj przeczytane książki do wyzwania
    @PatchMapping("/add-books")
    public ResponseEntity<Challenge> addBooksRead(@RequestBody AddBooksRequest request) {
        Challenge challenge = challengeService.addBooksRead(request.getBooksRead());
        return ResponseEntity.ok(challenge);
    }
}