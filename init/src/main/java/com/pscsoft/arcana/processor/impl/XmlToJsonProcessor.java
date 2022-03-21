package com.pscsoft.arcana.processor.impl;

import com.pscsoft.arcana.processor.AoAnylse;
import com.pscsoft.arcana.sdk.Category;
import com.pscsoft.arcana.sdk.ProcessorName;
import org.json.JSONObject;
import org.json.XML;

import java.util.Map;

//@Category("INTEGRATION2")
//@ProcessorName("xml_to_json")
public class XmlToJsonProcessor extends AoAnylse {
    @Override
    public void AnylseMessage(String message, Map resultMap) {
        JSONObject jsonObject = XML.toJSONObject(message);
        resultMap.put("_raw", message);
        resultMap.put("data", jsonObject);
    }
}




