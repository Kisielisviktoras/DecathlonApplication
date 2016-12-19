package com.homework.file.read;

import com.homework.domain.exception.UnsupportedFileType;
import com.homework.mapper.MaleParticipantPerformanceMapper;

/**
 * @author Viktoras Kisielis
 */
public class FileParserFactory {

    public FileParser getFileProcessor(String extension) throws UnsupportedFileType {
        switch (extension.toLowerCase()) {
            case "txt": {
                //Currently only male competition supported
                return new TextFileParser(";", new MaleParticipantPerformanceMapper());
            }
            default: {
                throw new UnsupportedFileType(String.format("Unsupported file format %s", extension));
            }
        }
    }
}
