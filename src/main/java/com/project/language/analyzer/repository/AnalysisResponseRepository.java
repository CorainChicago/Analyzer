package com.project.language.analyzer.repository;

import com.project.language.analyzer.entity.AnalyzeResponse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalysisResponseRepository extends MongoRepository<AnalyzeResponse, String> {

    AnalyzeResponse findFirstByName(String name);
}
