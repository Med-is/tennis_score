package com.bforbank.tennisscore;

import com.bforbank.tennisscore.service.TennisService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
public class TennisGameServiceTests {

    private final TennisService tennisGameService;
    @Autowired
    public TennisGameServiceTests(TennisService tennisGameService) {
        this.tennisGameService = tennisGameService;
    }

    @Test
    public void testComputeScore() {
        String result = tennisGameService.computeScore("ABABABABABABABAB");
        String expected = "Player A: 15 / Player B: 0\n" +
                "Player A: 15 / Player B: 15\n" +
                "Player A: 30 / Player B: 15\n" +
                "Player A: 30 / Player B: 30\n" +
                "Player A: 40 / Player B: 30\n" +
                "Player A: 40 / Player B: 40\n" +
                "Advantage Player A\n" +
                "Deuce\n" +
                "Advantage Player A\n" +
                "Deuce\n" +
                "Advantage Player A\n" +
                "Deuce\n" +
                "Advantage Player A\n" +
                "Deuce\n" +
                "Advantage Player A\n" +
                "Deuce\n";
        assertEquals(expected, result);
    }

    @Test
    public void testInvalidInput() {
        tennisGameService.resetGame();
        String result = tennisGameService.computeScore("XY");
        System.out.println(result+" "+"Invalid input");
        assertEquals("Invalid input", result);
    }

    @Test
    public void testGameWin() {
        tennisGameService.resetGame();
        String result = tennisGameService.computeScore("AAAABBB");
        String expected = "Player A: 15 / Player B: 0\n" +
                "Player A: 30 / Player B: 0\n" +
                "Player A: 40 / Player B: 0\n" +
                "Player A wins the game\n"+
                "Player A: 0 / Player B: 15\n"+
                "Player A: 0 / Player B: 30\n"+
                "Player A: 0 / Player B: 40\n";
        assertEquals(expected, result);
    }

}


