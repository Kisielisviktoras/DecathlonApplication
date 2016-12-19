package com.homework.file;

import com.homework.domain.exception.UnsupportedFileType;
import com.homework.file.read.FileParserFactory;
import com.homework.file.read.TextFileParser;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Saji on 12/18/2016.
 */
public class FileParserFactoryTest {

    private FileParserFactory testSubject = new FileParserFactory();

    @Test(expected = UnsupportedFileType.class)
    public void testUnsupportedFile() throws Exception {
        testSubject.getFileProcessor("csv");
    }

    @Test
    public void testTextFileParsesHandlesTxt() throws UnsupportedFileType {
        Assert.assertEquals(testSubject.getFileProcessor("txt").getClass(), TextFileParser.class);
    }

}