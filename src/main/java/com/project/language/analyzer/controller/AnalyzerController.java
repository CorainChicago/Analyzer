package com.project.language.analyzer.controller;

import com.project.language.analyzer.AnalyzerService;
import com.project.language.analyzer.entity.AnalyzeResponse;
import com.project.language.analyzer.model.AnalyzeRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AnalyzerController {

    private final AnalyzerService service;

    public AnalyzerController(AnalyzerService service) {
        this.service = service;
    }

    @GetMapping(value = "/previous")
    public @ResponseBody List<AnalyzeResponse> getLatestAnalysis(@RequestParam(value="count", required=true) Integer count){
        return service.getPrevious(count);
    }

    @PostMapping(value = "/")
    public @ResponseBody AnalyzeResponse postAnalysis(@RequestBody AnalyzeRequest request) {
        return service.processAndSave(request);
    }
}

