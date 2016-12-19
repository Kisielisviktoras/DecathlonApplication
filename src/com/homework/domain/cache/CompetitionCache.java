package com.homework.domain.cache;

import com.homework.domain.Competition;
import com.homework.domain.constant.CompetitionEvent;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Viktoras Kisielis
 */
public class CompetitionCache {

    private static Map<CompetitionEvent, Competition> competitions;
    private static CompetitionCache instance;

    private CompetitionCache() {
        competitions = new HashMap();
        competitions.put(CompetitionEvent.HUNDRED_METRES, new Competition(CompetitionEvent.HUNDRED_METRES, 25.4347, 18, 1.81));
        competitions.put(CompetitionEvent.LONG_JUMP, new Competition(CompetitionEvent.LONG_JUMP, 0.14354, 220, 1.4));
        competitions.put(CompetitionEvent.SHOT_PUT, new Competition(CompetitionEvent.SHOT_PUT, 51.39, 1.5, 1.05));
        competitions.put(CompetitionEvent.HIGH_JUMP, new Competition(CompetitionEvent.HIGH_JUMP, 0.8465, 75, 1.42));
        competitions.put(CompetitionEvent.FOUR_HUNDRED_METRES, new Competition(CompetitionEvent.FOUR_HUNDRED_METRES, 1.53775, 82, 1.81));
        competitions.put(CompetitionEvent.HUNDRED_METRES_HURDLES, new Competition(CompetitionEvent.HUNDRED_METRES_HURDLES, 5.74352, 28.5, 1.92));
        competitions.put(CompetitionEvent.DISCUS_THROW, new Competition(CompetitionEvent.DISCUS_THROW, 12.91, 4, 1.1));
        competitions.put(CompetitionEvent.POLE_VAULT, new Competition(CompetitionEvent.POLE_VAULT, 0.2797, 100, 1.35));
        competitions.put(CompetitionEvent.JAVELIN_THROW, new Competition(CompetitionEvent.JAVELIN_THROW, 10.14, 7, 1.08));
        competitions.put(CompetitionEvent.FIFTEEN_HUNDRED_METRES, new Competition(CompetitionEvent.FIFTEEN_HUNDRED_METRES, 0.03768, 480, 1.85));
        competitions.put(CompetitionEvent.HUNDRED_TEN_METRES_HURDLES, new Competition(CompetitionEvent.HUNDRED_TEN_METRES_HURDLES, 5.74352, 28.5, 1.92));
    }

    public static CompetitionCache getInstance() {
        if (competitions == null) {
            instance = new CompetitionCache();
        }
        return instance;
    }

    public Competition getCompetition(CompetitionEvent event) {
        return competitions.get(event);
    }

}
