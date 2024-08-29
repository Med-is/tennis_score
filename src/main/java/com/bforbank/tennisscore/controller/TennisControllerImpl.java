package com.bforbank.tennisscore.controller;

import com.bforbank.tennisscore.service.TennisService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tennis")
public class TennisControllerImpl {

    private static final Logger logger = LogManager.getLogger(TennisControllerImpl.class);

    private final TennisService tennisService;
    @Autowired
    public TennisControllerImpl(TennisService tennisService) {
        this.tennisService = tennisService;
    }

    // Endpoint pour obtenir le score
    @GetMapping("/compute")
    public String computeScore(@RequestParam String input) {
        logger.info( "Compute the score");
        return tennisService.computeScore(input);
    }

    // Endpoint pour réinitialiser le jeu
    @PostMapping("/reset")
    public String resetGame() {
        tennisService.resetGame();
        logger.info( "Game has been reset.");
        return "Game has been reset.";
    }
}
