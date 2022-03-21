package com.pscsoft.arcana.processor.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * @ClassName： JsonUtils
 * @description: json字符串处理
 * @author: ning.yang
 * @create: 2022/2/12 11:04
 */
public class JsonUtils {

    public static boolean getJSONType(String str) {
        boolean result = false;
        if (StringUtils.isNotBlank(str)) {
            str = str.trim();
            if (str.startsWith("{") && str.endsWith("}")) {
                result = true;
            } else if (str.startsWith("[") && str.endsWith("]")) {
                result = true;
            }
        }
        return result;
    }
}
