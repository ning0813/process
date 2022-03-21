package com.pscsoft.arcana.sdk;

import java.util.Map;

public interface SsoService {
  String getRedirectURL(Map paramMap) throws Exception;
  
  Map login(Map paramMap) throws Exception;
  
  String logout(Object paramObject) throws Exception;
}