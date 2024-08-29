package com.bforbank.tennisscore.model;

public class Player {
    private String name;
    private int scoreIndex = 0;
    private boolean hasAdvantage = false;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getScoreIndex() {
        return scoreIndex;
    }

    public void setScoreIndex(int scoreIndex) {
        this.scoreIndex = scoreIndex;
    }

    public boolean hasAdvantage() {
        return hasAdvantage;
    }

    public void setAdvantage(boolean hasAdvantage) {
        this.hasAdvantage = hasAdvantage;
    }
}