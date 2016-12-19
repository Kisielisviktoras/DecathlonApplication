package com.homework;

import com.homework.domain.DecathlonParticipant;
import com.homework.domain.Ranking;
import com.homework.domain.exception.UnsupportedFileType;
import com.homework.service.FileService;
import com.homework.service.DecathlonRankingService;

import java.util.List;

/**
 * @author viktoras kisielis
 */
public class DecathlonApplication {

    public static void main(String[] args) throws UnsupportedFileType {
        FileService fileService = new FileService();
        String inputFilePath = args[0];
        String outputFilePath = args[1];

        List<DecathlonParticipant> participants = fileService.readResultSheet(inputFilePath);
        DecathlonRankingService decathlonRankingService = new DecathlonRankingService();
        participants.stream().forEach(participant -> participant.setTotalScore(decathlonRankingService.calculateParticipantScore(participant)));
        List<Ranking> rankings = decathlonRankingService.rankParticipants(participants);

        fileService.writeResultSheet(outputFilePath, rankings);
    }



}
