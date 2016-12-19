package com.homework.domain;

import com.homework.domain.constant.CompetitionEvent;
import com.homework.domain.constant.CompetitionType;

/**
 * @author Viktoras Kisielis
 */
public class Competition {

    private final CompetitionEvent competitionEvent;
    private final CompetitionType competitionType;
    private final double A;
    private final double B;
    private final double C;

    public Competition(CompetitionEvent competitionEvent, double a, double b, double c) {
        this.competitionEvent = competitionEvent;
        this.competitionType = competitionEvent.getEventType();
        this.A = a;
        this.B = b;
        this.C = c;
    }

    public CompetitionEvent getCompetitionEvent() {
        return competitionEvent;
    }

    public CompetitionType getCompetitionType() {
        return competitionType;
    }

    public double getA() {
        return A;
    }

    public double getB() {
        return B;
    }

    public double getC() {
        return C;
    }

    @Override
    public String toString() {
        return "Competition{" +
                "competitionEvent=" + competitionEvent +
                '}';
    }
}
