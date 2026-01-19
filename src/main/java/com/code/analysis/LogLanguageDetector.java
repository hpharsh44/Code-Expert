package com.code.analysis;

import org.springframework.stereotype.Component;

@Component
public class LogLanguageDetector {

    public LogLanguage detect(String logs) {

        // Java
        if (logs.contains("Exception")
                && logs.contains("at ")
                && logs.contains("java.")) {
            return LogLanguage.JAVA;
        }

        // Python
        if (logs.contains("Traceback (most recent call last)")
                || logs.contains("File \"")) {
            return LogLanguage.PYTHON;
        }

        // C#
        if (logs.contains("System.")
                && logs.contains("at ")
                && logs.contains(".cs:line")) {
            return LogLanguage.CSHARP;
        }

        return LogLanguage.UNKNOWN;
    }
}
