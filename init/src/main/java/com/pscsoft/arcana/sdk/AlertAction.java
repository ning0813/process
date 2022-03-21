package com.pscsoft.arcana.sdk;

import java.util.Map;

public interface AlertAction {
  void execute(Map<String, Object> paramMap);
}