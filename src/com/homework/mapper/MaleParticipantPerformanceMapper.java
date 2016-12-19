package com.homework.mapper;

import com.homework.domain.DecathlonEvent;
import com.homework.domain.cache.CompetitionCache;
import com.homework.domain.constant.CompetitionEvent;
import com.homework.domain.DecathlonParticipant;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Viktoras Kisielis
 */
public class MaleParticipantPerformanceMapper extends ParticipantPerformanceMapper {

    private CompetitionCache cache = CompetitionCache.getInstance();

    @Override
    public DecathlonParticipant mapToParticipant(String[] participantAttributes) {
        if (participantAttributes != null && participantAttributes.length >= 10) {
            DecathlonParticipant decathlonParticipant = new DecathlonParticipant();
            decathlonParticipant.setName(participantAttributes[0]);

            List<DecathlonEvent> competitionList = new ArrayList<>();
            competitionList.add(new DecathlonEvent(cache.getCompetition(CompetitionEvent.HUNDRED_METRES), Double.valueOf(participantAttributes[1])));
            competitionList.add(new DecathlonEvent(cache.getCompetition(CompetitionEvent.LONG_JUMP), convertToCentimetres(participantAttributes[2])));
            competitionList.add(new DecathlonEvent(cache.getCompetition(CompetitionEvent.SHOT_PUT), Double.valueOf(participantAttributes[3])));
            competitionList.add(new DecathlonEvent(cache.getCompetition(CompetitionEvent.HIGH_JUMP), convertToCentimetres(participantAttributes[4])));
            competitionList.add(new DecathlonEvent(cache.getCompetition(CompetitionEvent.FOUR_HUNDRED_METRES), Double.valueOf(participantAttributes[5])));
            competitionList.add(new DecathlonEvent(cache.getCompetition(CompetitionEvent.HUNDRED_TEN_METRES_HURDLES), Double.valueOf(participantAttributes[6])));
            competitionList.add(new DecathlonEvent(cache.getCompetition(CompetitionEvent.DISCUS_THROW), Double.valueOf(participantAttributes[7])));
            competitionList.add(new DecathlonEvent(cache.getCompetition(CompetitionEvent.POLE_VAULT), convertToCentimetres(participantAttributes[8])));
            competitionList.add(new DecathlonEvent(cache.getCompetition(CompetitionEvent.JAVELIN_THROW), Double.valueOf(participantAttributes[9])));
            competitionList.add(new DecathlonEvent(cache.getCompetition(CompetitionEvent.FIFTEEN_HUNDRED_METRES), convertToSeconds(participantAttributes[10])));
            decathlonParticipant.setDecathlonEvents(competitionList);
            return decathlonParticipant;
        }

        throw new IllegalArgumentException("Incomplete decathlon participant data provided");

    }

}
