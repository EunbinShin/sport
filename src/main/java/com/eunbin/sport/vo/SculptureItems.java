package com.eunbin.sport.vo;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SculptureItems {
    @JsonProperty("item")
    private List<SculptureItem> sculptureItems;

    @JsonCreator
    public SculptureItems(@JsonProperty("response")JsonNode node) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode itemNode = node.findValue("item");

        this.sculptureItems = Arrays.stream(objectMapper.treeToValue(itemNode, SculptureItem[].class)).toList();
    }
}
