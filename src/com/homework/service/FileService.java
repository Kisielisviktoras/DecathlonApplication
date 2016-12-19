package com.homework.service;

import com.homework.domain.Ranking;
import com.homework.domain.exception.UnsupportedFileType;
import com.homework.file.read.FileParser;
import com.homework.file.write.FileWriterFactory;
import com.homework.domain.DecathlonParticipant;
import com.homework.file.read.FileParserFactory;
import com.homework.file.write.FileWriter;

import java.util.List;

/**
 * @author Viktoras Kisielis
 */
public class FileService {

    private FileParserFactory fileParserFactory = new FileParserFactory();
    private FileWriterFactory fileWriterFactory = new FileWriterFactory();

    public List<DecathlonParticipant> readResultSheet(String performanceSourcePath) throws UnsupportedFileType {
        String extension = getFileExtension(performanceSourcePath);
        FileParser fileParser = fileParserFactory.getFileProcessor(extension);
        return fileParser.getParticipants(performanceSourcePath);
    }

    public void writeResultSheet(String rankingResultPath, List<Ranking> rankings) throws UnsupportedFileType {
        String extension = getFileExtension(rankingResultPath);
        FileWriter fileWriter = fileWriterFactory.getFileWriter(extension);
        fileWriter.writeResult(rankings, rankingResultPath);
    }

    private String getFileExtension(String path) {
        String extension = "";

        int i = path.lastIndexOf('.');
        if (i >= 0) {
            extension = path.substring(i+1);
        }
        return extension;
    }
}
