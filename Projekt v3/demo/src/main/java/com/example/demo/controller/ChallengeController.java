package com.example.demo.controller;

import com.example.demo.model.Challenge;
import com.example.demo.repository.ChallengeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/challenges")
public class ChallengeController {

    @Autowired
    private ChallengeRepository challengeRepository;

    @PostMapping
    public Challenge setChallenge(@RequestBody Challenge challenge) {
        return challengeRepository.save(challenge);
    }

    @GetMapping("/{userId}")
    public Challenge getChallengeByUserId(@PathVariable Long userId) {
        return challengeRepository.findByUserId(userId);
    }

    @PatchMapping("/{userId}")
    public Challenge updateChallenge(@PathVariable Long userId, @RequestBody Challenge challenge) {
        Challenge existingChallenge = challengeRepository.findByUserId(userId);
        if (existingChallenge != null) {
            existingChallenge.setBooksRead(challenge.getBooksRead());
            return challengeRepository.save(existingChallenge);
        }
        return null;
    }
}