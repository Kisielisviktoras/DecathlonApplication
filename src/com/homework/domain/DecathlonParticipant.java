package com.homework.domain;

import java.util.List;

/**
 * @author Viktoras Kisielis
 */
public class DecathlonParticipant {

    private String name;
    //event performance
    private List<DecathlonEvent> decathlonEvents;
    private int totalScore;

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DecathlonEvent> getDecathlonEvents() {
        return decathlonEvents;
    }

    public void setDecathlonEvents(List<DecathlonEvent> decathlonEvents) {
        this.decathlonEvents = decathlonEvents;
    }

    @Override
    public String toString() {
        return "DecathlonParticipant{" +
                "name='" + name + '\'' +
                '}';
    }
}
