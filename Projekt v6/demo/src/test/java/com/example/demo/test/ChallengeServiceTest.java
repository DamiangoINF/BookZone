package com.example.demo.test;

import com.example.demo.model.Challenge;
import com.example.demo.repository.ChallengeRepository;
import com.example.demo.service.ChallengeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ChallengeServiceTest {

    @Mock
    private ChallengeRepository challengeRepository;

    @InjectMocks
    private ChallengeService challengeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSetChallenge() {
        // Arrange
        Challenge challenge = new Challenge();
        challenge.setGoal(10);
        challenge.setBooksRead(0);

        when(challengeRepository.findById(1L)).thenReturn(Optional.empty());
        when(challengeRepository.save(challenge)).thenReturn(challenge);

        // Act
        Challenge result = challengeService.setChallenge(10);

        // Assert
        assertEquals(10, result.getGoal());
        verify(challengeRepository, times(1)).findById(1L);
        verify(challengeRepository, times(1)).save(challenge);
    }

    @Test
    void testAddBooksRead() {
        // Arrange
        Challenge challenge = new Challenge();
        challenge.setGoal(10);
        challenge.setBooksRead(5);

        when(challengeRepository.findById(1L)).thenReturn(Optional.of(challenge));
        when(challengeRepository.save(challenge)).thenReturn(challenge);

        // Act
        Challenge result = challengeService.addBooksRead(3);

        // Assert
        assertEquals(8, result.getBooksRead());
        verify(challengeRepository, times(1)).findById(1L);
        verify(challengeRepository, times(1)).save(challenge);
    }
}