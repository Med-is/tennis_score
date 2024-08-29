package com.bforbank.tennisscore.service;

import com.bforbank.tennisscore.model.Player;
import com.bforbank.tennisscore.model.Tennis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TennisServiceImpl implements TennisService{

   private final Tennis tennisGame ;
    @Autowired
    public TennisServiceImpl(Tennis tennisGame) {
        this.tennisGame = tennisGame;
    }

    @Override
    public void playerWonBall(Player player, Player opponent, StringBuilder result) {
        tennisGame.playerWonBall(player,opponent,result);
    }

    @Override
    public void resetGame() {
        tennisGame.resetGame();
    }

    @Override
    public String computeScore(String input) {
        return tennisGame.computeScore(input);
    }
}
