package com.homework.domain.constant;


/**
 * @author Viktoras Kisielis
 */
public enum CompetitionEvent {
    HUNDRED_METRES(CompetitionType.TRACK),
    LONG_JUMP(CompetitionType.FIELD),
    SHOT_PUT(CompetitionType.FIELD),
    HIGH_JUMP(CompetitionType.FIELD),
    FOUR_HUNDRED_METRES(CompetitionType.TRACK),
    HUNDRED_METRES_HURDLES(CompetitionType.TRACK),
    HUNDRED_TEN_METRES_HURDLES(CompetitionType.TRACK),
    DISCUS_THROW(CompetitionType.FIELD),
    POLE_VAULT(CompetitionType.FIELD),
    JAVELIN_THROW(CompetitionType.FIELD),
    FIFTEEN_HUNDRED_METRES(CompetitionType.TRACK);

    CompetitionType eventType;

    CompetitionEvent(CompetitionType eventType) {
        this.eventType = eventType;
    }

    public CompetitionType getEventType() {
        return eventType;
    }
}
