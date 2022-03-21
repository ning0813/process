package com.pscsoft.arcana.processor.entry;
import java.util.ArrayList;
import java.util.List;








public class ParseRules
{
  private final List<String[]> arrs = (List)new ArrayList<>();


  public List<String[]> getArrs() {
    return this.arrs;
  }

  public void put(String field, String regex) {
    String[] ls = { field, regex };
    this.arrs.add(ls);
  }
}