package com.homework.service;

import com.homework.competition.rules.FieldEventRule;
import com.homework.competition.rules.Rule;
import com.homework.competition.rules.TrackEventRule;
import com.homework.domain.DecathlonEvent;
import com.homework.domain.DecathlonParticipant;
import com.homework.domain.Ranking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Service responsible grading decathlon participants
 * @author Viktoras Kisielis
 */
public class DecathlonRankingService {

    private List<Rule> rules = Arrays.asList(new FieldEventRule(), new TrackEventRule());

    /**
     * Calculates participant score based on his performances in competition events
     * @param participant
     * @return
     */
    public int calculateParticipantScore(DecathlonParticipant participant) {
        int score = 0;
        for (DecathlonEvent event : participant.getDecathlonEvents()) {
            int competitionScore = 0;
            for (Rule rule : rules) {
                competitionScore += rule.getCompetitionScore(event.getScore(), event.getCompetition());
            }
            score += competitionScore;
        }
        return score;
    }

    /**
     * Ranks participants based on their total score
     * @param participants
     * @return
     */
    public List<Ranking> rankParticipants(List<DecathlonParticipant> participants) {
        //Group participants on score
        Map<Integer, List<DecathlonParticipant>> groupedByScore = groupByScore(participants);
        //Sort by score
        SortedSet<Integer> keys = new TreeSet<>(Collections.reverseOrder());
        keys.addAll(groupedByScore.keySet());

        //Build rankings based on score groups
        List<Ranking> rankingList = new ArrayList<>();
        int place = 1;
        StringBuilder rankingPlaceBuilder = new StringBuilder(String.valueOf(place));
        for (Integer score : keys) {
            int sameScoreCount = groupedByScore.get(score).size();
            if (sameScoreCount > 1) {
                place = place + sameScoreCount - 1;
                rankingPlaceBuilder.append(String.format("-%s", place));
            }
            List<String> participantsNames = groupedByScore.get(score).stream().map(DecathlonParticipant::getName).collect(Collectors.toList());
            rankingList.add(new Ranking(rankingPlaceBuilder.toString(), score, participantsNames));
            place++;
            rankingPlaceBuilder = new StringBuilder(String.valueOf(place));
        }

        return rankingList;
    }

    private Map<Integer, List<DecathlonParticipant>> groupByScore(List<DecathlonParticipant> participants) {
        Map<Integer, List<DecathlonParticipant>> result = new HashMap<>();
        if (participants != null) {
            for (DecathlonParticipant participant : participants) {
                List<DecathlonParticipant> sameScoreParticipants = result.get(participant.getTotalScore());

                if (sameScoreParticipants == null) {
                    sameScoreParticipants = new ArrayList<>();
                    result.put(participant.getTotalScore(), sameScoreParticipants);
                }
                sameScoreParticipants.add(participant);
            }
        }
        return result;
    }

}
