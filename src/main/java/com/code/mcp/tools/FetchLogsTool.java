package com.code.mcp.tools;

import com.code.mcp.McpTool;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

@Component
public class FetchLogsTool implements McpTool {

    @Override
    public String getName() {
        return "fetchLogs";
    }

    @Override
    public String getDescription() {
        return "Fetch logs for a given service";
    }

    @Override
    public Map<String, Object> execute(Map<String, Object> input) {

        String service = (String) input.get("service");

        try {
            String logs = Files.readString(Path.of("logs/" + service + ".log"));
            return Map.of("logs", logs);
        } catch (Exception e) {
            return Map.of("error", "Unable to read logs");
        }
    }
}
