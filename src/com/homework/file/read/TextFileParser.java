package com.homework.file.read;

import com.homework.domain.DecathlonParticipant;
import com.homework.mapper.MaleParticipantPerformanceMapper;
import com.homework.mapper.ParticipantPerformanceMapper;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Viktoras Kisielis
 */

public class TextFileParser implements FileParser {

    private String separator;
    private ParticipantPerformanceMapper participantPerformanceMapper;
    private FileReader reader = new FileReader();

    public TextFileParser(String separator, MaleParticipantPerformanceMapper participantPerformanceMapper){
        this.separator = separator;
        this.participantPerformanceMapper = participantPerformanceMapper;
    }

    @Override
    public List<DecathlonParticipant> getParticipants(String resultSheetPath) {
        List<String> lines = reader.readLines(resultSheetPath);
        return lines.stream().map(line -> line.split(separator)).
                map(attributes -> participantPerformanceMapper.mapToParticipant(attributes)).collect(Collectors.toList());
    }
}
