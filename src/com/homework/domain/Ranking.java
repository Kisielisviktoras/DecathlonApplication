package com.homework.domain;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author Viktoras Kisielis
 */
public class Ranking {

    private int points;
    private List<String> participantNames;
    private String rankPlace;

    public Ranking() {
    }

    public Ranking(String rankPlace, int points, List<String> participantNames) {
        this.rankPlace = rankPlace;
        this.participantNames = participantNames;
        this.points = points;
    }

    public String getRankPlace() {
        return rankPlace;
    }

    public void setRankPlace(String rankPlace) {
        this.rankPlace = rankPlace;
    }

    public List<String> getParticipantNames() {
        return participantNames;
    }

    public void setParticipantNames(List<String> participantNames) {
        this.participantNames = participantNames;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override public String toString() {
        return "Ranking{" +
                "rankPlace='" + rankPlace + '\'' +
                ", points=" + points +
                ", participantNames=" + participantNames +
                '}';
    }
}
