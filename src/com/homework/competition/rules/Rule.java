package com.homework.competition.rules;

import com.homework.domain.Competition;

/**
 * @author Viktoras Kisielis
 */
public interface Rule {

    /**
     * Calculates score based on competition and performance
     * @param performance
     * @param competition
     * @return
     */
    int getCompetitionScore(double performance, Competition competition);
}
