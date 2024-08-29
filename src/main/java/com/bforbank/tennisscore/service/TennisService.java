package com.bforbank.tennisscore.service;

import com.bforbank.tennisscore.model.Player;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public interface TennisService {
    void playerWonBall(Player player, Player opponent, StringBuilder result);
    void resetGame();
    String computeScore(String input);
}
