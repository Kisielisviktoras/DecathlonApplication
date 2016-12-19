package com.homework.mapper;

import com.homework.domain.DecathlonEvent;
import com.homework.domain.DecathlonParticipant;
import com.homework.domain.constant.CompetitionEvent;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by Saji on 12/18/2016.
 */
public class MaleParticipantPerformanceMapperTest {

    private MaleParticipantPerformanceMapper maleParticipantPerformanceMapper = new MaleParticipantPerformanceMapper();

    @Test(expected = IllegalArgumentException.class)
    public void testIncompleteList() throws Exception {
        maleParticipantPerformanceMapper.mapToParticipant(new String[1]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testListNull() throws Exception {
        maleParticipantPerformanceMapper.mapToParticipant(null);
    }

    @Test
    public void testConvertToCentimeters() {
        Assert.assertEquals(Double.valueOf(265), maleParticipantPerformanceMapper.convertToCentimetres("2.65"));
        Assert.assertEquals(Double.valueOf(0), maleParticipantPerformanceMapper.convertToCentimetres(null));
        Assert.assertEquals(Double.valueOf(0), maleParticipantPerformanceMapper.convertToCentimetres(""));
    }

    @Test
    public void testConvertToSeconds() {
        Assert.assertEquals(Double.valueOf(325.72), maleParticipantPerformanceMapper.convertToSeconds("5.25.72"));
        Assert.assertEquals(Double.valueOf(0), maleParticipantPerformanceMapper.convertToSeconds(null));
        Assert.assertEquals(Double.valueOf(0), maleParticipantPerformanceMapper.convertToSeconds(""));
    }

    /**
     * Day 1
     100 metres
     Long jump
     Shot put
     High jump
     400 metres
     Day 2
     110 metres hurdles
     Discus throw
     Pole vault
     Javelin throw
     1500 metres
     */
    @Test
    public void testMapCompetitionInOrder() {
        String[] line = new String[11];
        line[0] = "Siim Susi";
        line[1] = "12.61";
        line[2] = "5.00";
        line[3] = "9.22";
        line[4] = "1.50";
        line[5] = "60.39";
        line[6] = "16.43";
        line[7] = "21.60";
        line[8] = "2.60";
        line[9] = "35.81";
        line[10] = "5.25.72";

        DecathlonParticipant participant = maleParticipantPerformanceMapper.mapToParticipant(line);

        Map<Double, DecathlonEvent> map = participant.getDecathlonEvents().stream()
                .collect(Collectors.toMap(DecathlonEvent::getScore, Function.identity()));


        Assert.assertEquals(map.get(12.61).getCompetition().getCompetitionEvent(), CompetitionEvent.HUNDRED_METRES);
        Assert.assertEquals(map.get(500.0).getCompetition().getCompetitionEvent(), CompetitionEvent.LONG_JUMP);
        Assert.assertEquals(map.get(9.22).getCompetition().getCompetitionEvent(), CompetitionEvent.SHOT_PUT);
        Assert.assertEquals(map.get(150.0).getCompetition().getCompetitionEvent(), CompetitionEvent.HIGH_JUMP);
        Assert.assertEquals(map.get(60.39).getCompetition().getCompetitionEvent(), CompetitionEvent.FOUR_HUNDRED_METRES);
        Assert.assertEquals(map.get(16.43).getCompetition().getCompetitionEvent(), CompetitionEvent.HUNDRED_TEN_METRES_HURDLES);
        Assert.assertEquals(map.get(21.60).getCompetition().getCompetitionEvent(), CompetitionEvent.DISCUS_THROW);
        Assert.assertEquals(map.get(260.0).getCompetition().getCompetitionEvent(), CompetitionEvent.POLE_VAULT);
        Assert.assertEquals(map.get(35.81).getCompetition().getCompetitionEvent(), CompetitionEvent.JAVELIN_THROW);
        Assert.assertEquals(map.get(325.72).getCompetition().getCompetitionEvent(), CompetitionEvent.FIFTEEN_HUNDRED_METRES);
    }

}