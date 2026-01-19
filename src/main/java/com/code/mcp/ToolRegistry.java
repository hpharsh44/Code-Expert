package com.code.mcp;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ToolRegistry {

    private final Map<String, McpTool> tools = new HashMap<>();

    public ToolRegistry(List<McpTool> toolList) {
        toolList.forEach(tool -> tools.put(tool.getName(), tool));
    }

    public McpTool getTool(String name) {
        return tools.get(name);
    }

    public Map<String, McpTool> getAllTools() {
        return tools;
    }
}
