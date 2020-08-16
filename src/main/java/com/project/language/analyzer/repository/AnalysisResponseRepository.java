package com.project.language.analyzer.repository;

import com.project.language.analyzer.entity.AnalyzeResponse;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnalysisResponseRepository extends MongoRepository<AnalyzeResponse, String> {

    AnalyzeResponse findByName(String name);


    List<AnalyzeResponse> findAll();

}
