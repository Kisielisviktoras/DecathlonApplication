package com.homework.file.read;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Viktoras Kisielis
 */
public class FileReader {

    public List<String> readLines(String filePath) {
        List<String> list = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            list = stream.map(s -> s).collect(Collectors.toList());

        } catch (IOException e) {
            System.out.println(String.format("Error while reading source file: %s", e.getMessage()));
        }

        return list;
    }
}
