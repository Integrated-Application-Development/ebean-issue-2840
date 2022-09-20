package iad.sample.test.ebean;

import io.ebean.annotation.DbJson;
import io.ebean.annotation.MutationDetection;
import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TestObject {
  @Id
  private String id;

  @DbJson(mutationDetection = MutationDetection.NONE)
  private Map<String, Object> testMapJson;

  @DbJson(mutationDetection = MutationDetection.NONE)
  private Object testObjectJson;

  public TestObject(String id, Map<String, Object> testMapJson, Object testObjectJson) {
    setId(id);
    setTestMapJson(testMapJson);
    setTestObjectJson(testObjectJson);
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Map<String, Object> getTestMapJson() {
    return testMapJson;
  }

  public void setTestMapJson(Map<String, Object> testMapJson) {
    this.testMapJson = testMapJson;
  }

  public Object getTestObjectJson() {
    return testObjectJson;
  }

  public void setTestObjectJson(Object testObjectJson) {
    this.testObjectJson = testObjectJson;
  }
}
