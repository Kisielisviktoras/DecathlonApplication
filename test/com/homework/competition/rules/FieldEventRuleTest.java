package com.homework.competition.rules;

import com.homework.domain.constant.CompetitionType;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Saji on 12/18/2016.
 */
public class FieldEventRuleTest {

    private FieldEventRule testSubject = new FieldEventRule();

    @Test
    public void testIsApplicableToFieldEvents() throws Exception {
        Assert.assertTrue(testSubject.isApplicable(CompetitionType.FIELD));
    }

    @Test
    public void testIsNotApplicableToFieldEvents() throws Exception {
        Assert.assertFalse(testSubject.isApplicable(CompetitionType.TRACK));
    }

    @Test
    public void testBenchmarkScore() throws Exception {
        //Long jump
        Assert.assertTrue(testSubject.calculateScore(776, 0.14354, 220, 1.4)> 900);
        //Shot put
        Assert.assertTrue(testSubject.calculateScore(18.4, 51.39, 1.5, 1.05)> 900);
        //High jump
        Assert.assertTrue(testSubject.calculateScore(221, 0.8465, 75, 1.42) > 900);
        //Discus throw
        Assert.assertTrue(testSubject.calculateScore(56.17, 12.91, 4, 1.1)> 900);
        //Pole vault
        Assert.assertTrue(testSubject.calculateScore(528, 0.2797, 100, 1.35)> 900);
        //Javelin throw
        Assert.assertTrue(testSubject.calculateScore(77.19, 10.14, 7, 1.08)> 900);
    }

}