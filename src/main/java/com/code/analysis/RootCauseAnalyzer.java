package com.code.analysis;

import org.springframework.stereotype.Component;

@Component
public class RootCauseAnalyzer {

    public String analyze(String logs, LogLanguage language) {

        switch (language) {

            case JAVA:
                if (logs.contains("OutOfMemoryError")) {
                    return "JVM heap memory exhausted";
                }
                if (logs.contains("Connection refused")) {
                    return "Downstream service not reachable";
                }
                break;

            case PYTHON:
                if (logs.contains("ModuleNotFoundError")) {
                    return "Missing Python dependency";
                }
                if (logs.contains("KeyError")) {
                    return "Invalid dictionary key access";
                }
                break;

            case CSHARP:
                if (logs.contains("NullReferenceException")) {
                    return "Object reference not set to an instance";
                }
                if (logs.contains("SqlException")) {
                    return "Database operation failure";
                }
                break;
        }

        return "Unknown root cause";
    }
}
