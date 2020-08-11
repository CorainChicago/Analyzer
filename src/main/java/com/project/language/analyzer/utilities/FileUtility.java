package com.project.language.analyzer.utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class FileUtility {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileUtility.class);


    public List<String> readFile(String name) {
        List<String> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/text/" + name))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                result.addAll(Arrays.asList(line.split(" ")));
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
        return result;
    }
}
