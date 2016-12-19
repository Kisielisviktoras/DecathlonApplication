package com.homework.mapper;

import com.homework.domain.DecathlonParticipant;

/**
 * @author Viktoras Kisielis
 */

public abstract class ParticipantPerformanceMapper {

    public abstract DecathlonParticipant mapToParticipant(String[] participantAttributes);

    protected Double convertToSeconds(String time) {
        if (time != null && !time.isEmpty()) {
            String[] splitTime = time.trim().split("\\.");
            Double seconds = Double.valueOf(splitTime[0]) * 60;
            seconds += Double.valueOf(splitTime[1]);

            if (splitTime.length > 2) {
                seconds += Double.valueOf(splitTime[2])/100;
            }
            return seconds;
        }
        return Double.valueOf(0);
    }

    protected Double convertToCentimetres(String jumpHeight) {
        if (jumpHeight != null && !jumpHeight.isEmpty()) {
            double centimetres = Double.valueOf(jumpHeight);
            return centimetres * 100;
        }
        return Double.valueOf(0);
    }
}
