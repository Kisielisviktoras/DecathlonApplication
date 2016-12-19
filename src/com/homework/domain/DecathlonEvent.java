package com.homework.domain;

/**
 * @author Viktoras Kisielis
 */
public class DecathlonEvent {

    private double score;
    private Competition competition;

    public DecathlonEvent(Competition competition, double score) {
        this.score = score;
        this.competition = competition;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }
}
