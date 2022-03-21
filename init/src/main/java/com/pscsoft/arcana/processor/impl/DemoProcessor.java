package com.pscsoft.arcana.processor.impl;

import com.pscsoft.arcana.processor.AoAnylse;
import com.pscsoft.arcana.processor.entry.ParseResult;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * @ClassName： DemoProcessor
 * @description: 解析
 * @author: ning.yang
 * @create: 2022/1/13 15:21
 */
//@Category({"demo"})
//@ProcessorName("demo")
public class DemoProcessor extends AoAnylse {

    protected void AnylseMessage(String message, Map<String, Object> resultMap) {
        String[] fields = {"_time", "host", "source", "sourcetype", "msg"};
        String[] regexes = {"(\\w{3}\\s+\\d+\\s+\\d+\\:\\d+\\:\\d+)(?=\\s\\d+\\.\\d+\\.\\d+\\.\\d+)", "(\\d+\\.\\d+\\.\\d+\\.\\d+)(?=\\s\\w{3}\\s+\\d+)", "appServer", "(?<=appServer )(.+?)(?=\\:)", "(?<=\\:\\s)(.+)(?=\\s)"};
        ParseResult parseResult = new ParseResult(0, "", "", true);
        resultMap.put("_raw", message);
        Map<String, Object> parsedFields = new HashMap<>();
        for (int i = 0; i < fields.length; i++) {
            parseResult = findRegexMatch(message, fields[i], regexes[i], parseResult.pos);
            if ("_time".equals(fields[i])) {
                SimpleDateFormat format = new SimpleDateFormat("MMM d HH:mm:ss yyyy", Locale.ENGLISH);
                //时间格式如：Nov 25 13:34:03
                SimpleDateFormat resultformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
                    String str_year = sdf.format(new Date());
                    String time_value = parseResult.value.toString();
                    time_value = time_value + " " + str_year;
                    parseResult.value = resultformat.format(format.parse(time_value));
                } catch (Exception e) {
                    parseResult.value = resultformat.format(new Date());
                }
            }
            parsedFields.put(fields[i], parseResult.value);
        }
        if (!parsedFields.isEmpty()) {
            resultMap.putAll(parsedFields);
        }
    }
}
