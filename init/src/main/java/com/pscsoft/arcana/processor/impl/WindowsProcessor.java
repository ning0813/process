package com.pscsoft.arcana.processor.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pscsoft.arcana.processor.AoAnylse;
import com.pscsoft.arcana.processor.entry.ParseResult;
import com.pscsoft.arcana.processor.utils.JsonUtils;
import com.pscsoft.arcana.sdk.Category;
import com.pscsoft.arcana.sdk.ProcessorName;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName： ArubaProcessor
 * @description: 解析
 * @author: ning.yang
 * @create: 2022/2/118 15:21
 */
@Category({"Windows"})
@ProcessorName("Windows_logset")
public class WindowsProcessor extends AoAnylse {

    protected void AnylseMessage(String message, Map<String, Object> resultMap) {
        try {
            if (JsonUtils.getJSONType(message)) {
                Map<String, Object> messgeMap = JSON.parseObject(message, Map.class);
                resultMap.putAll(messgeMap);
                if (messgeMap.get("event") != null) {
                    String event = messgeMap.get("event").toString();
                    Map<String, Object> eventMap = JSON.parseObject(event, Map.class);
                    resultMap.put("_time", eventMap.get("created"));
                }
                if (messgeMap.get("fields") != null) {
                    String fields = messgeMap.get("fields").toString();
                    Map<String, Object> fieldsMap = JSON.parseObject(fields, Map.class);
                    if (fieldsMap.get("metadata") != null) {
                        Map<String, Object> metadata = JSON.parseObject(fieldsMap.get("metadata").toString(), Map.class);
                        resultMap.put("host", metadata.get("host"));
                    }
                }
            } else {
                JSONObject jsonObject = JSON.parseObject(message);
                resultMap.putAll(jsonObject);
            }

        } catch (Exception e) {
            resultMap.put("_raw", message);
        }
    }
    
}
