package com.pscsoft.arcana.processor.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


public class XmlProcessorTest {


    @Test
    public void anylseMessage() {
        String messge1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><log-message><timestamp>2022-02-22T07:10:14.817+08:00</timestamp><severity>ERROR</severity><application-id></application-id><subsystem-id></subsystem-id><host-name>ZSDAS06</host-name><log-origin>com.ge.med.rumba.svcapps.rasm.DataManager</log-origin><thread-id>Timer-1</thread-id><uid></uid><message>com.ge.med.rumba.svcapps.rasm.DataManagerLogData@156f0cd</message><user-id></user-id><additional-info></additional-info><exception></exception></log-message>";
        HashMap<String, Object> res = new HashMap<>();
        XmlToJsonProcessor xmlToJsonProcessor = new XmlToJsonProcessor();
        xmlToJsonProcessor.AnylseMessage(messge1, res);
        System.out.println(res.get("data"));
    }

}