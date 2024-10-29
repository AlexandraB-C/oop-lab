package lab0;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

// record to store universe data
public record Universe(
    String name,
    List<JsonNode> individuals
) {}