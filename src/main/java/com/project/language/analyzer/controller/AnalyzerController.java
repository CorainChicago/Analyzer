package com.project.language.analyzer.controller;

import com.project.language.analyzer.AnalyzerService;
import com.project.language.analyzer.model.AnalyzeRequest;
import com.project.language.analyzer.model.AnalyzeResponse;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Controller
public class AnalyzerController {

    private final AnalyzerService service;

    public AnalyzerController(AnalyzerService service) {
        this.service = service;
    }

    @GetMapping(value = "/name")
    public @ResponseBody AnalyzeResponse getAnalysisByName(@RequestParam(value="name", required=true) String name){
       return null;
    }

    @GetMapping(value = "/analysis")
    public @ResponseBody AnalyzeResponse getLatestAnalysis(@RequestParam(value="count", required=true) String count){
        return null;
    }

    @PostMapping(value = "/")
    public @ResponseBody AnalyzeResponse postAnalysis(@RequestBody AnalyzeRequest request) {
        return service.processAndSave(request);
    }
}

