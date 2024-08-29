package com.bforbank.tennisscore.model;

import org.springframework.stereotype.Component;


public interface Tennis {
    public void playerWonBall(Player player, Player opponent, StringBuilder result);
    void resetGame();
    String computeScore(String input);
}
