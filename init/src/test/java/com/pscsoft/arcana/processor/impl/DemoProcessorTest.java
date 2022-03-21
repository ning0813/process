package com.pscsoft.arcana.processor.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.net.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;


public class DemoProcessorTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void anylseMessage() {
        String messge1 = "<190>Nov 25 13:34:03 2812239202000738(root) 44243630 Traffic@FLOW: SESSION: 10.18.9.34:58813->10.16.6.14:8004(TCP), application Redis, interface ethernet0/8, vr trust-vr, policy 1198, user -@- host - mac 0000.0000.0000, send packets 11, send bytes 713, receive packets 7, receive bytes 428, start time 2021-11-25 13:32:32. close time 2021-11-25 13:34:03. session end. TCP RST";
        DemoProcessor jsPro = new DemoProcessor();
        Map<String, Object> resultMap = new HashMap<>();
        jsPro.AnylseMessage(messge1, resultMap);
        System.out.println(resultMap);
    }

}