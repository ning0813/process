package com.pscsoft.arcana.processor.entry;

public class ParseResult {
  public int pos;
  public String field;
  public Object value;
  public boolean parsed;

  public ParseResult(int pos, String field, Object value, boolean parsed) {
    this.pos = pos;
    this.field = field;
    this.value = value;
    this.parsed = parsed;
  }
}