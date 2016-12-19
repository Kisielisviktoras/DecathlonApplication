package com.homework.competition.rules;

import com.homework.domain.constant.CompetitionType;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Saji on 12/18/2016.
 */
public class TrackEventRuleTest {

    private TrackEventRule testSubject = new TrackEventRule();

    @Test
    public void testIsApplicableToFieldEvents() throws Exception {
        Assert.assertFalse(testSubject.isApplicable(CompetitionType.FIELD));
    }

    @Test
    public void testIsNotApplicableToFieldEvents() throws Exception {
        Assert.assertTrue(testSubject.isApplicable(CompetitionType.TRACK));
    }

    @Test
    public void testBenchmarkScore() throws Exception {
        //100m
        Assert.assertTrue(testSubject.calculateScore(10.395, 25.4347, 18, 1.81)> 900);
        //400m
        Assert.assertTrue(testSubject.calculateScore(46.17, 1.53775, 82, 1.81)> 900);
        //110m hurdles
        Assert.assertTrue(testSubject.calculateScore(13.8, 5.74352, 28.5, 1.92)> 900);
        //1500m
        Assert.assertTrue(testSubject.calculateScore(233.79, 0.03768, 480, 1.85)> 900);
    }

}