package com.eunbin.sport.vo;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
@AllArgsConstructor
public class GalleryItems {
    @JsonProperty("item")
    private List<GalleryItem> galleryItems;

    @JsonCreator
    public GalleryItems(@JsonProperty("response")JsonNode node) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode itemNode = node.findValue("item");

        for (JsonNode item : itemNode) {
            item.fields().forEachRemaining(entry -> {
                String key = entry.getKey();
                String value = entry.getValue().asText();
                if (value.startsWith("<![CDATA[") && value.endsWith("]]>")) {
                    value = value.substring(9, value.length() - 3);
                    ((ObjectNode) item).put(key, value);
                }
            });
        }

        this.galleryItems = Arrays.stream(objectMapper.treeToValue(itemNode, GalleryItem[].class)).toList();
    }
}
