package com.bforbank.tennisscore.model;

import org.springframework.stereotype.Component;

@Component
public class TennisImpl implements Tennis {
    private static final int[] scores = {0, 15, 30, 40};
    private final Player playerA = new Player("Player A");
    private final Player playerB = new Player("Player B");

    public String computeScore(String input) {
        StringBuilder result = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (c == 'A') {
                playerWonBall(playerA, playerB, result);
            } else if (c == 'B') {
                playerWonBall(playerB, playerA, result);
            } else {
                return "Invalid input";
            }

            if (isGameWon(playerA) || isGameWon(playerB)) {
                result.append(playerA.hasAdvantage() ? playerA.getName() : playerB.getName()).append(" wins the game\n");
                return result.toString();
            }
        }

        return result.toString();
    }

    public void playerWonBall(Player player, Player opponent, StringBuilder result) {
        if (player.hasAdvantage()) {
            result.append(player.getName()).append(" wins the game\n");
            resetGame();
        } else if (opponent.hasAdvantage()) {
            opponent.setAdvantage(false);
            result.append("Deuce\n");
        } else if (player.getScoreIndex() == 3 && opponent.getScoreIndex() == 3) {
            player.setAdvantage(true);
            result.append("Advantage ").append(player.getName()).append("\n");
        } else if (player.getScoreIndex() < 3) {
            player.setScoreIndex(player.getScoreIndex() + 1);
            result.append("Player A: ").append(scores[playerA.getScoreIndex()])
                    .append(" / Player B: ").append(scores[playerB.getScoreIndex()]).append("\n");
        } else {
            result.append(player.getName()).append(" wins the game\n");
            resetGame();
        }
    }

    public void resetGame() {
        playerA.setScoreIndex(0);
        playerB.setScoreIndex(0);
        playerA.setAdvantage(false);
        playerB.setAdvantage(false);
    }

    private boolean isGameWon(Player player) {
        return player.hasAdvantage() && player.getScoreIndex() > 3;
    }

}