package com.homework.competition.rules;

import com.homework.domain.constant.CompetitionType;

/**
 * @author Viktoras Kisielis
 */
public class FieldEventRule extends AbstractRule {

    @Override
    public boolean isApplicable(CompetitionType type) {
        return CompetitionType.FIELD == type;
    }

    @Override
    public int calculateScore(double performance, double a, double b, double c) {
        return (int) (a * Math.pow(performance-b, c));
    }
}
