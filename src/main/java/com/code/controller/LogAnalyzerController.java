package com.code.controller;

import com.code.agent.LogAnalysisAgent;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/logs")
public class LogAnalyzerController {

    private final LogAnalysisAgent agent;

    public LogAnalyzerController(LogAnalysisAgent agent) {
        this.agent = agent;
    }

    @PostMapping("/analyze")
    public Map<String, Object> analyze(@RequestParam String service) {
        return agent.analyze(service);
    }
}
