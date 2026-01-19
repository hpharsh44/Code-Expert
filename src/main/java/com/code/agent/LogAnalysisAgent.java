package com.code.agent;

import com.code.analysis.FixSuggestionEngine;
import com.code.analysis.LogLanguage;
import com.code.analysis.LogLanguageDetector;
import com.code.analysis.RootCauseAnalyzer;
import com.code.mcp.ToolRegistry;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LogAnalysisAgent {

    private final ToolRegistry toolRegistry;
    private final LogLanguageDetector detector;
    private final RootCauseAnalyzer analyzer;
    private final FixSuggestionEngine fixer;

    public LogAnalysisAgent(
            ToolRegistry toolRegistry,
            LogLanguageDetector detector,
            RootCauseAnalyzer analyzer,
            FixSuggestionEngine fixer) {

        this.toolRegistry = toolRegistry;
        this.detector = detector;
        this.analyzer = analyzer;
        this.fixer = fixer;
    }

    public Map<String, Object> analyze(String service) {

        String logs = (String) toolRegistry
                .getTool("fetchLogs")
                .execute(Map.of("service", service))
                .get("logs");

        LogLanguage language = detector.detect(logs);
        String rootCause = analyzer.analyze(logs, language);
        String fix = fixer.suggestFix(rootCause);

        return Map.of(
                "language", language,
                "rootCause", rootCause,
                "suggestedFix", fix
        );
    }
}
