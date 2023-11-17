package com.eunbin.sport.vo;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
public class ClassItems {
    @JsonProperty("item")
    private List<ClassItem> classItems;

    @JsonCreator
    public ClassItems(@JsonProperty("response")JsonNode node) throws JsonProcessingException {
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

                if(key.equals("item_url")){
                    String regex = "txtCLSS_SEQ_N=(\\d+)";
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher = pattern.matcher(value);

                    if (matcher.find()) {
                        String extractedNumber = matcher.group(1);
                        value = "https://soma.kspo.or.kr/class/"+extractedNumber;
                    }else{
                        value = "https://soma.kspo.or.kr/class/01/list";
                    }

                    ((ObjectNode) item).put(key, value);
                }
            });
        }

        this.classItems = Arrays.stream(objectMapper.treeToValue(itemNode, ClassItem[].class)).toList();
    }
    
}
