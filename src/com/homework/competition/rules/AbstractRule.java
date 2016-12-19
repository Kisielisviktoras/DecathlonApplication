package com.homework.competition.rules;

import com.homework.domain.Competition;
import com.homework.domain.constant.CompetitionType;

/**
 * @author Viktoras Kisielis
 */
public abstract class AbstractRule implements Rule {

    abstract boolean isApplicable(CompetitionType type);
    abstract int calculateScore(double performance, double a, double b, double c);

    public int getCompetitionScore(double performance, Competition competition) {
        if (isApplicable(competition.getCompetitionType())) {
            return calculateScore(performance, competition.getA(), competition.getB(), competition.getC());
        } return 0;
    }

}
