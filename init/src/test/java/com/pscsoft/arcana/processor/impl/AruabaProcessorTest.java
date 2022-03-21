package com.pscsoft.arcana.processor.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


public class AruabaProcessorTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void anylseMessage() {
        String messge = "<12> 2022-02-24T05:11:11+08:00 4 1 00419 10.86.9.4   hostname  auth:  Invalid user name/password on SSH session User 'test' is trying to login from 10.86.136.158 ";
        ArubaProcessor arubaProcessor = new ArubaProcessor();
        Map<String, Object> resultMap = new HashMap<>();
        arubaProcessor.AnylseMessage(messge, resultMap);
        System.out.println(resultMap);
    }

}