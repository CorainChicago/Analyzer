package com.project.language.analyzer;

import com.project.language.analyzer.utilities.FileUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.print.DocFlavor;
import java.util.List;

@Service
public class AnalyzerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AnalyzerService.class);

    private final FileUtility fileUtility;

    private List<String> text;
    private List<String> stopWords;

    public AnalyzerService(FileUtility fileUtility) {
        this.fileUtility = fileUtility;
    }

    @PostConstruct
    public void initialize(){
       text = fileUtility.readFile("exercisedocument.txt");
       stopWords =  fileUtility.readFile("stopwords.txt");

       LOGGER.info("This is the text file length {}", text.size());
       LOGGER.info("This is the stopWords file length {}", stopWords.size());
    }


}
