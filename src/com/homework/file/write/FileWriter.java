package com.homework.file.write;

import com.homework.domain.Ranking;

import java.io.File;
import java.util.List;

/**
 * @author Viktoras Kisielis
 */
public interface FileWriter {

    File writeResult(List<Ranking> rankings, String outputPath);
}
