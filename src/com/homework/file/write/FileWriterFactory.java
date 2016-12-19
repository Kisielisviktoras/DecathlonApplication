package com.homework.file.write;

import com.homework.domain.exception.UnsupportedFileType;

/**
 * @author Viktoras Kisielis
 */
public class FileWriterFactory {

    public FileWriter getFileWriter(String extension) throws UnsupportedFileType {
        switch (extension.toLowerCase()) {
            case "xml" :
                return new PrettyXmlFileWriterDecorator();
            default:
                throw new UnsupportedFileType("Unsupported output format selected");
        }
    }
}
