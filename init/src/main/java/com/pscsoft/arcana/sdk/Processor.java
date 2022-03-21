package com.pscsoft.arcana.sdk;

import com.pscsoft.arcana.sdk.ForwardEvent;

import java.util.List;
import java.util.Map;

public interface Processor {
  List<Map> onTrigger(ForwardEvent paramForwardEvent) throws Exception;
  
  default void init() {}
}