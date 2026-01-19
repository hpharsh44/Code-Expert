package com.example.codeexpert.mcp;

import java.util.Map;

public interface McpTool {

    String getName();

    String getDescription();

    Map<String, Object> execute(Map<String, Object> input);
}
