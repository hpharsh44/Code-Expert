package com.code.analysis;

import org.springframework.stereotype.Component;

@Component
public class FixSuggestionEngine {

    public String suggestFix(String rootCause) {

        if (rootCause.contains("heap")) {
            return "Increase JVM heap size and restart service";
        }

        if (rootCause.contains("dependency")) {
            return "Install missing dependency and redeploy";
        }

        if (rootCause.contains("NullReference")) {
            return "Add null checks before object access";
        }

        if (rootCause.contains("Database")) {
            return "Verify DB connectivity and credentials";
        }

        return "Manual investigation required";
    }
}
