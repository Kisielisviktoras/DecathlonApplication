package com.homework.service;

import com.homework.domain.Competition;
import com.homework.domain.DecathlonEvent;
import com.homework.domain.DecathlonParticipant;
import com.homework.domain.Ranking;
import com.homework.domain.constant.CompetitionEvent;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Saji on 12/19/2016.
 */
public class DecathlonRankingServiceTest {

    private DecathlonRankingService testSubject = new DecathlonRankingService();

    private static final double MY_RUNNING_SCORE = 1d;
    private static final double MY_JAVELIN_SCORE = 5d;


    @Test
    public void calculateParticipantScore() throws Exception {
        //Score 1
        Competition runningCompetition = new Competition(CompetitionEvent.HUNDRED_METRES, 1, 2, 2);
        DecathlonEvent runningEvent = new DecathlonEvent(runningCompetition, MY_RUNNING_SCORE);
        //Score 9
        Competition javelinCompetition = new Competition(CompetitionEvent.JAVELIN_THROW, 1, 2, 2);
        DecathlonEvent javelinThrowEvent = new DecathlonEvent(javelinCompetition, MY_JAVELIN_SCORE);

        DecathlonParticipant participant = new DecathlonParticipant();
        participant.setDecathlonEvents(Arrays.asList(runningEvent, javelinThrowEvent));
        int totalScore = testSubject.calculateParticipantScore(participant);

        Assert.assertEquals(10, totalScore);
    }

    @Test
    public void testRankParticipantsScoreEqual() {
        DecathlonParticipant participantA = new DecathlonParticipant();
        participantA.setTotalScore(1);
        DecathlonParticipant participantB = new DecathlonParticipant();
        participantB.setTotalScore(1);

        List<Ranking> result = testSubject.rankParticipants(Arrays.asList(participantA, participantB));

        Assert.assertEquals(1, result.size());
        Assert.assertEquals("1-2", result.get(0).getRankPlace());
        Assert.assertEquals(2, result.get(0).getParticipantNames().size());
    }

    @Test
    public void testRankParticipantsScoreNotEqual() {
        DecathlonParticipant participantA = new DecathlonParticipant();
        participantA.setTotalScore(2);
        DecathlonParticipant participantB = new DecathlonParticipant();
        participantA.setTotalScore(1);

        List<Ranking> result = testSubject.rankParticipants(Arrays.asList(participantA, participantB));

        Assert.assertEquals(2, result.size());
        Assert.assertEquals("1", result.get(0).getRankPlace());
        Assert.assertEquals("2", result.get(1).getRankPlace());
        Assert.assertEquals(1, result.get(0).getParticipantNames().size());
        Assert.assertEquals(1, result.get(1).getParticipantNames().size());
    }

    @Test
    public void testEmptyList() {
        List<Ranking> result = testSubject.rankParticipants(Collections.emptyList());
        Assert.assertEquals(0, result.size());
    }

    @Test
    public void testNull() {
        List<Ranking> result = testSubject.rankParticipants(null);
        Assert.assertEquals(0, result.size());
    }
}