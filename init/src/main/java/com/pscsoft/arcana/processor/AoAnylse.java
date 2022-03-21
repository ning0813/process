package com.pscsoft.arcana.processor;
import com.alibaba.fastjson.JSON;
import com.pscsoft.arcana.processor.entry.ParseResult;
import com.pscsoft.arcana.sdk.ForwardEvent;
import com.pscsoft.arcana.sdk.Processor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AoAnylse implements Processor {
        public List<Map> onTrigger(ForwardEvent forwardEvent) throws Exception {
        List<Map> results = new ArrayList<>();
//        Map resultMap = AnylseMetadata(forwardEvent.getMetadata());
        String message = null;
        Map<String, Object> resultMap = new HashMap<>();
        if (resultMap.size() != 3) {

            resultMap.clear();
            message = (String)forwardEvent.getMessage();
        } else {
            Map<String, Object> messgeMap = (Map<String, Object>)JSON.parseObject((String)forwardEvent.getMessage(), Map.class);

            message = (String)messgeMap.get("message");
        }
        AnylseMessage(message, resultMap);
        results.add(resultMap);
        return results;
    }



    protected Map AnylseMetadata(Map<String, Object> env) {
        List<String> keys = Arrays.asList(new String[] { "user_system", "log_filename", "log_service" });
        Map<Object, Object> resultMap = new HashMap<>();
        for (Map.Entry<String, Object> entry : env.entrySet()) {
            String key = entry.getKey();
            if (!keys.contains(key)) {
                continue;
            }
            resultMap.put(key, entry.getValue());
        }

        return resultMap;
    }

    protected abstract void AnylseMessage(String paramString, Map<String, Object> paramMap) throws Exception;

    public ParseResult findRegexMatch(String message, String field, String regex, int pos) {
        boolean parsed = true;
        String fieldValue = "";
        Matcher m = Pattern.compile(regex).matcher(message);
        if (m.find()) {
            pos = m.end();
            fieldValue = message.substring(m.start(), m.end());
        } else {
            parsed = false;
        }
        return new ParseResult(pos, field, fieldValue, parsed);
    }
}