package com.pscsoft.arcana.processor.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


public class WindowsProcessorTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void anylseMessage() {
        String messge1 = "{\"@timestamp\":\"2022-03-18T07:01:20.250Z\",\"@metadata\":{\"beat\":\"winlogbeat\",\"type\":\"_doc\",\"version\":\"7.13.1\"},\"event\":{\"category\":[\"process\"],\"sequence\":21,\"created\":\"2022-03-18T07:01:20.678Z\",\"kind\":\"event\",\"module\":\"powershell\",\"type\":[\"info\"],\"code\":\"800\",\"provider\":\"PowerShell\",\"action\":\"管道执行详细信息\"},\"host\":{\"os\":{\"type\":\"windows\",\"platform\":\"windows\",\"version\":\"10.0\",\"family\":\"windows\",\"name\":\"Windows Server 2019 Standard\",\"kernel\":\"10.0.17763.973 (WinBuild.160101.0800)\",\"build\":\"17763.973\"},\"hostname\":\"CTXXD\",\"name\":\"CTXXD.holalab.com\",\"architecture\":\"x86_64\"},\"file\":{\"path\":\"C:\\\\Program Files\\\\Citrix\\\\ConfigSync\\\\ConfigSync.ps1\",\"name\":\"ConfigSync.ps1\",\"directory\":\"C:\\\\Program Files\\\\Citrix\\\\ConfigSync\",\"extension\":\"ps1\"},\"user\":{\"domain\":\"HOLALAB\",\"name\":\"CTXXD$\"},\"related\":{\"user\":\"CTXXD$\"},\"winlog\":{\"task\":\"管道执行详细信息\",\"provider_name\":\"PowerShell\",\"computer_name\":\"CTXXD.holalab.com\",\"keywords\":[\"经典\"],\"opcode\":\"信息\",\"api\":\"wineventlog\",\"event_id\":\"800\",\"channel\":\"Windows PowerShell\",\"record_id\":35633774},\"fields\":{\"metadata\":{\"host\":\"192.168.4.20\"}},\"message\":\"命令行的管道执行详细信息: Add-Type -AssemblyName System.Security\\n。\\n\\n上下文信息: \\n\\tDetailSequence=1\\n\\tDetailTotal=1\\n\\n\\tSequenceNumber=21\\n\\n\\tUserId=HOLALAB\\\\CTXXD$\\n\\tHostName=Default Host\\n\\tHostVersion=5.1.17763.771\\n\\tHostId=dd40c6bc-bfd6-43fa-90a4-8b231e7c438f\\n\\tHostApplication=ConfigSyncRun.exe False\\n\\tEngineVersion=5.1.17763.771\\n\\tRunspaceId=7ea7c8a3-1005-4173-8eae-a5caf7399e6f\\n\\tPipelineId=1\\n\\tScriptName=C:\\\\Program Files\\\\Citrix\\\\ConfigSync\\\\ConfigSync.ps1\\n\\tCommandLine=Add-Type -AssemblyName System.Security\\n \\n\\n详细信息: \\nCommandInvocation(Add-Type):“Add-Type”\\nParameterBinding(Add-Type): 名称 =“AssemblyName”；值 =“System.Security”\",\"process\":{\"args\":[\"ConfigSyncRun.exe\",\"False\"],\"args_count\":2,\"entity_id\":\"dd40c6bc-bfd6-43fa-90a4-8b231e7c438f\",\"command_line\":\"ConfigSyncRun.exe False\",\"title\":\"Default Host\"},\"powershell\":{\"runspace_id\":\"7ea7c8a3-1005-4173-8eae-a5caf7399e6f\",\"process\":{\"executable_version\":\"5.1.17763.771\"},\"command\":{\"value\":\"Add-Type -AssemblyName System.Security\",\"invocation_details\":[{\"type\":\"CommandInvocation\",\"related_command\":\"Add-Type\",\"value\":\"“Add-Type”\"},{\"value\":\"名称 =“AssemblyName”；值 =“System.Security”\"}]},\"total\":1,\"sequence\":1,\"engine\":{\"version\":\"5.1.17763.771\"},\"pipeline_id\":\"1\"}}\n";
        WindowsProcessor jsPro = new WindowsProcessor();
        Map<String, Object> resultMap = new HashMap<>();
        jsPro.AnylseMessage(messge1, resultMap);
        System.out.println(resultMap);
    }

}