package com.pscsoft.arcana.processor.impl;

import com.pscsoft.arcana.processor.AoAnylse;
import com.pscsoft.arcana.processor.entry.ParseResult;
import com.pscsoft.arcana.sdk.Category;
import com.pscsoft.arcana.sdk.ProcessorName;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName： ArubaProcessor
 * @description: 解析
 * @author: ning.yang
 * @create: 2022/2/118 15:21
 */
//@Category({"Saint-Gobain"})
//@ProcessorName("Aruba")
public class ArubaProcessor extends AoAnylse {

    protected void AnylseMessage(String message, Map<String, Object> resultMap) {
        
        String[] fields = {"PRI","_time","SyslogSeverity","SyslogFacility", "SyslogTag", "host","Sub_System", "Description"};
        String[] regexes = {"(?<=\\<).+(?=\\>)","(\\d+\\-+\\d+\\-\\d+T+\\d+\\:+\\d+\\:\\d+\\+\\d+\\:\\d+)","\\w+(?=\\s\\d+\\s\\d{5})","\\d+(?=\\s\\d{5})","(\\d{5,50})(?=\\s\\d+\\.\\d+\\.\\d+\\.\\d+)","(?<=\\w{5,10}\\s).+(?=\\s+\\w+\\:)","(\\w{3,10})(?=\\:\\s)","(?<=\\w+\\:\\s\\s).+"};
        ParseResult parseResult = new ParseResult(0, "", "", true);
        resultMap.put("_raw", message);
        Map<String, Object> parsedFields = new HashMap<>();
        for (int i = 0; i < fields.length; i++) {
            parseResult = findRegexMatch(message, fields[i], regexes[i], parseResult.pos);
//
            if ("_time".equals(fields[i])) {
                parsedFields.put("time", parseResult.value);
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                SimpleDateFormat resultformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                try {
                    String time_value = parseResult.value.toString();
                    parseResult.value = resultformat.format(format.parse(time_value));
                } catch (Exception e) {
                    e.printStackTrace();
                    parseResult.value = resultformat.format(new Date());
                }
            }
            if ("host".equals(fields[i])) {
                try {
                    String host_value = parseResult.value.toString();
                    String[] split = host_value.split("\\s+");
                    parseResult.value = split[0];
                    parsedFields.put("HOSTNAME", split[1]);
                } catch (Exception e) {
                    String hostPattern = "(\\d+\\.\\d+\\.\\d+\\.\\d+)";
                    Matcher hostmatcher = Pattern.compile(hostPattern).matcher(message);
                    if (hostmatcher.find()) {
                        parseResult.value = hostmatcher.group(0);
                    }
                }
            }
            parsedFields.put(fields[i], parseResult.value);
        }
        if (!parsedFields.isEmpty()) {
            resultMap.putAll(parsedFields);
        }
    }
}
