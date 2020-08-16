package com.project.language.analyzer;

import com.project.language.analyzer.model.AnalyzeRequest;
import com.project.language.analyzer.entity.AnalyzeResponse;
import com.project.language.analyzer.repository.AnalysisResponseRepository;
import com.project.language.analyzer.utilities.FileUtility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class AnalyzerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AnalyzerService.class);

    private final FileUtility fileUtility;
    private final AnalysisResponseRepository repository;

    private HashMap<String, List<String>> text;
    private List<String> stopWords;

    public AnalyzerService(
            FileUtility fileUtility,
            AnalysisResponseRepository repository) {
        this.fileUtility = fileUtility;
        this.repository = repository;
    }

    @PostConstruct
    public void initialize() {
        try {
            stopWords = fileUtility.readFile("stopWords/*").get("stopwords.txt");
            text = fileUtility.readFile("text/*");
            text.forEach((k, v) -> {
                if (Objects.isNull(repository.findByName(k))) {
                    repository.save(new AnalyzeResponse(k, v.toString()));
                }
            });
        } catch (IOException e) {
            LOGGER.error("IOException occurred {}", e);
        }
    }

    public AnalyzeResponse processAndSave(AnalyzeRequest request) {
        AnalyzeResponse response;
        List<String> list;
        if (Objects.isNull(request.getText()) || request.getText().isEmpty() || request.getText().isBlank()) {
            response = repository.findByName(request.getName());
            LOGGER.error("response {}", response);
            list  = convertStringIntoCleanList(response.getOriginal());
        } else {
            response = new AnalyzeResponse(request.getName(), request.getUseStopWords(), request.getUseRootWords());
            list = convertStringIntoCleanList(request.getText());
            response.setOriginal(request.getText());
        }

        if (request.getUseStopWords()) {
            list = list.stream().filter(word -> !stopWords.contains(word)).collect(Collectors.toList());
        }
        if (request.getUseRootWords()) {
           list = list.stream().map(word -> getStemWords(word)).collect(Collectors.toList());
        }

        response.setResult(generateWordCount(list));
        response.setTop25WordsUsed(findTop25Words(response.getResult()));
        repository.save(response);

        LOGGER.info("saved");
        LOGGER.info("get {}", repository.findAll());

        return response;
    }

    private List<String> convertStringIntoCleanList(String text) {
        return Arrays.asList(text.replaceAll("[$,&.:�??^0-9]", "").split(" "));
    }

    private LinkedHashMap<String, Integer> generateWordCount(List<String> list) {
        HashMap<String, Integer> result = new HashMap<>();
        list.forEach(word -> {
            if (result.containsKey(word)) {
                Integer count = result.get(word);
                count++;
                result.put(word, count);
            } else {
                result.put(word, 1);
            }
        });
        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        result.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

        List<Map.Entry<String, Integer>> entries = new ArrayList<Map.Entry<String, Integer>>(sortedMap.entrySet());

        Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
                return entry2.getValue() - entry1.getValue();
            }
        });

        return entries.stream().collect(Collectors.toMap(Map.Entry::getKey,
                Map.Entry::getValue,
                (v1, v2) -> v1,
                LinkedHashMap::new));

    }

    private String getStemWords(String word) {
        if (word.endsWith("L") && !word.endsWith("ZL") && !word.endsWith("EZL") && word.length() > 1) {
            return word.substring(0, word.length() - 1);
        }
        if (word.endsWith("“LZ") && word.length() > 2) {
            return word.substring(0, word.length() - 2);
        }
        if (word.endsWith("EVM") && word.length() > 3) {
            return word.substring(0, word.length() - 3);
        }
        if (word.endsWith("“ZQ") && !word.endsWith("EZL") && word.length() > 2) {
            return word.substring(0, word.length() - 2);
        }
        if (word.endsWith("ZL") && !word.endsWith("PZL") && word.length() > 2) {
            return word.substring(0, word.length() - 2) + "A";
        }
        if (word.endsWith("PZL") && word.length() > 3) {
            return word.substring(0, word.length() - 3) + "AZ";
        }
        if (word.endsWith("EZL") && word.length() > 3) {
            return word.substring(0, word.length() - 3) + "R";
        }
        return word;
    }

    private List<String> findTop25Words(LinkedHashMap<String, Integer> hash) {
        List<String> results = new ArrayList<>(hash.keySet());
        if(results.size() >= 25) {
            return results.subList(0, 24);
        }else {
            return results;
        }
    }

    public AnalyzeResponse findByName(String name) {
        return repository.findByName(name);
    }

    public List<AnalyzeResponse> getPrevious(Integer count) {

        Comparator<AnalyzeResponse> compareByCreateAt = (AnalyzeResponse a, AnalyzeResponse b) -> a.getCreatedAt().compareTo( b.getCreatedAt());
        List<AnalyzeResponse> responses = repository.findAll();
        Collections.sort(responses, compareByCreateAt);
        return responses.subList(0, count);
    }
}
