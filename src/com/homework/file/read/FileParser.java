package com.homework.file.read;

import com.homework.domain.DecathlonParticipant;

import java.util.List;

/**
 * @author Viktoras Kisielis
 */
public interface FileParser {
    List<DecathlonParticipant> getParticipants(String resultSheetPath);
}
