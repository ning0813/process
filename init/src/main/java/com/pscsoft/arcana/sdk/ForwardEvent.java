package com.pscsoft.arcana.sdk;

import java.util.Map;

public class ForwardEvent {
  private String host;
  private String processor;
  private String sourceType;
  private String source;
  private String edgeId;
  private Object message;
  private String timestamp;
  private String timeField;
  private String timeMode;
  private String instanceId;
  private String index;
  private String forwardServer;
  private Object extData;
  private FieldsEvent fields;
  private Map<String, Object> metadata;

  public class FieldsEvent {
    private String processor;
    private String host;
    private String forward_server;
    private String edge_id;
    private String source;
    private String type;
    private String index;

    public String getProcessor() {
      return this.processor;
    }

    public void setProcessor(String processor) {
      this.processor = processor;
    }

    public String getHost() {
      return this.host;
    }

    public void setHost(String host) {
      this.host = host;
    }

    public String getForward_server() {
      return this.forward_server;
    }

    public void setForward_server(String forward_server) {
      this.forward_server = forward_server;
    }

    public String getEdge_id() {
      return this.edge_id;
    }

    public void setEdge_id(String edge_id) {
      this.edge_id = edge_id;
    }

    public String getSource() {
      return this.source;
    }

    public void setSource(String source) {
      this.source = source;
    }

    public String getType() {
      return this.type;
    }

    public void setType(String type) {
      this.type = type;
    }

    public String getIndex() {
      return this.index;
    }

    public void setIndex(String index) {
      this.index = index;
    }
  }







  public String getHost() {
    return this.host;
  }

  public void setHost(String host) {
    this.host = host;
  }

  public String getProcessor() {
    return this.processor;
  }

  public void setProcessor(String processor) {
    this.processor = processor;
  }

  public String getSourceType() {
    return this.sourceType;
  }

  public void setSourceType(String sourceType) {
    this.sourceType = sourceType;
  }

  public String getSource() {
    return this.source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public String getEdgeId() {
    return this.edgeId;
  }

  public void setEdgeId(String edgeId) {
    this.edgeId = edgeId;
  }

  public Object getMessage() {
    return this.message;
  }

  public void setMessage(Object message) {
    this.message = message;
  }

  public String getTimestamp() {
    return this.timestamp;
  }

  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }

  public String getInstanceId() {
    return this.instanceId;
  }

  public void setInstanceId(String instanceId) {
    this.instanceId = instanceId;
  }

  public String getIndex() {
    return this.index;
  }

  public void setIndex(String index) {
    this.index = index;
  }

  public String getForwardServer() {
    return this.forwardServer;
  }

  public void setForwardServer(String forwardServer) {
    this.forwardServer = forwardServer;
  }

  public String getTimeField() {
    return this.timeField;
  }

  public void setTimeField(String timeField) {
    this.timeField = timeField;
  }

  public String getTimeMode() {
    return this.timeMode;
  }

  public void setTimeMode(String timeMode) {
    this.timeMode = timeMode;
  }

  public Object getExtData() {
    return this.extData;
  }

  public void setExtData(Object extData) {
    this.extData = extData;
  }

  public FieldsEvent getFields() {
    return this.fields;
  }

  public void setFields(FieldsEvent fields) {
    this.fields = fields;
  }

  public Map<String, Object> getMetadata() {
    return this.metadata;
  }

  public void setMetadata(Map<String, Object> metadata) {
    this.metadata = metadata;
  }
}
