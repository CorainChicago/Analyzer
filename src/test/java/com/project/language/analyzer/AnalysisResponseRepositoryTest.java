//package com.project.language.analyzer;
//
//import com.project.language.analyzer.config.MongoConfig;
//import com.project.language.analyzer.entity.AnalyzeResponse;
//import com.project.language.analyzer.repository.AnalysisResponseRepository;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@ExtendWith(SpringExtension.class)
//@DataMongoTest
//@ContextConfiguration(classes = {MongoConfig.class})
//public class AnalysisResponseRepositoryTest {
//
//    @Autowired
//    private AnalysisResponseRepository underTest;
//
//    @Test
//    public void shouldCreateResponse() {
//        AnalyzeResponse response = new AnalyzeResponse("test");
//        AnalyzeResponse responseCreated = underTest.save(response);
//        assertEquals(response.getName(), responseCreated.getName());
//    }
//}
