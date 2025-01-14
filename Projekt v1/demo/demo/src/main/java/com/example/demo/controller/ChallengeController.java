package com.example.demo.controller;


import com.example.demo.model.Challenge;
import com.example.demo.repository.ChallengeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/challenges")
public class ChallengeController {

    @Autowired
    private ChallengeRepository challengeRepository;

    @GetMapping("/{userId}")
    public Challenge getChallengeByUserId(@PathVariable Long userId) {
        return challengeRepository.findByUserId(userId);
    }

    @PostMapping
    public Challenge createChallenge(@RequestBody Challenge challenge) {
        return challengeRepository.save(challenge);
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