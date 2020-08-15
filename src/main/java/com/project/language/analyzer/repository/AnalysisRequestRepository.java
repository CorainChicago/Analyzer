package com.project.language.analyzer.repository;

import com.project.language.analyzer.model.AnalyzeRequest;
import com.project.language.analyzer.model.AnalyzeResponse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnalysisRequestRepository extends MongoRepository<AnalyzeResponse, String> {

    List<String> findByName(String name);
}
