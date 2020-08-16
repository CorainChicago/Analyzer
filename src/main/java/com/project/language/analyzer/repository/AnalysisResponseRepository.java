package com.project.language.analyzer.repository;

import com.project.language.analyzer.model.AnalyzeRequest;
import com.project.language.analyzer.model.AnalyzeResponse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnalysisResponseRepository extends MongoRepository<AnalyzeResponse, String> {

    AnalyzeResponse findByName(String name);
}
