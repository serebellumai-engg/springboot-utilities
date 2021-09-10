package com.ac.dataloader.util;

import com.ac.dataloader.entity.orm.ORMObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class JsonUtil {

    public static List convertJsonNodeToObject(Class ormClass, List<JsonNode> records) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        List convertedRecords = new ArrayList<>(records.size());
        for (Object record : records) {
            ORMObject convertedRecord;
            convertedRecord = (ORMObject) mapper.readValue(record.toString(), ormClass);
            convertedRecords.add(convertedRecord);
        }
        return convertedRecords;
    }
}