package com.project.language.analyzer;

import com.project.language.analyzer.entity.AnalyzeResponse;
import com.project.language.analyzer.model.AnalyzeRequest;
import com.project.language.analyzer.repository.AnalysisResponseRepository;
import com.project.language.analyzer.utilities.FileUtility;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class AnalyzerServiceTest {

    @MockBean
    private FileUtility fileUtilityMock;
    @MockBean
    private AnalysisResponseRepository repositoryMock;
    private AnalyzerService underTest;

    @BeforeEach
    public void  setUp(){
        fileUtilityMock = mock(FileUtility.class);
        repositoryMock = mock(AnalysisResponseRepository.class);
        underTest = new AnalyzerService(fileUtilityMock, repositoryMock);
    }

    @Test
    public void initializeTest() throws IOException {
        underTest.initialize();
        verify(fileUtilityMock, times(2) ).readFile(anyString());
        verify(fileUtilityMock, times(2) ).readFile(anyString());
    }

    @Test
    public void processAndSaveHappyPath() {
        AnalyzeRequest request = new AnalyzeRequest(
                "test",
                "KMHFLDVQL HA LIEZVKEAEI DUKEISZL DUZ DUZE CFXSELMZQ DIUHLL DIUHLL DIUHLL QHGZVL HA BHFUVDSL DVQ QELIECSEVZL. LHNZ LK",
                true,
                true);
        AnalyzeResponse response = underTest.processAndSave(request);
        assertNotNull(response);
        assertEquals(response.getName(), request.getName());
        assertEquals("DIUHLL", response.getTop25WordsUsed().get(0) );
        assertEquals(3, response.getResult().get("DIUHLL"));
    }

    @Test
    public void processAndSaveWitStopWords() throws IOException {
        AnalyzeRequest request = new AnalyzeRequest(
                "test All Stop Words",
                "DSS FC CAT DOG CAT",
                true,
                true);
        HashMap<String, List<String>> stopMap = new HashMap<>();
        List<String> stopList = new ArrayList<>();
        stopList.add("DSS");
        stopList.add("FC");
        stopMap.put("stopwords.txt", stopList);
        when(fileUtilityMock.readFile("stopWords/*")).thenReturn(stopMap);
        underTest.initialize();
        AnalyzeResponse response = underTest.processAndSave(request);
        assertNotNull(response);
        assertEquals(response.getName(), request.getName());
        assertEquals(2, response.getTop25WordsUsed().size());
        assertEquals(2, response.getResult().size());
        assertEquals(2, response.getResult().get("CAT"));
    }

    @Test
    public void processAndSaveWitStopWordsAndRoots() throws IOException {
        AnalyzeRequest request = new AnalyzeRequest(
                "test All Stop Words",
                "DSS FC CAT DOG CAT CATEVM CAZL CA CA NGPZL",
                true,
                true);
        HashMap<String, List<String>> stopMap = new HashMap<>();
        List<String> stopList = new ArrayList<>();
        stopList.add("DSS");
        stopList.add("FC");
        stopMap.put("stopwords.txt", stopList);
        when(fileUtilityMock.readFile("stopWords/*")).thenReturn(stopMap);
        underTest.initialize();
        AnalyzeResponse response = underTest.processAndSave(request);
        assertNotNull(response);
        assertEquals(response.getName(), request.getName());
        assertEquals(5, response.getTop25WordsUsed().size());
        assertEquals(5, response.getResult().size());
        assertEquals(3, response.getResult().get("CAT"));
    }

    @Test
    void findByName() {
    }
}