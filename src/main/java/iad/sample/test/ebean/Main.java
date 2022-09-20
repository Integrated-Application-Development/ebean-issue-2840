package iad.sample.test.ebean;

import io.ebean.Database;
import io.ebean.Transaction;
import java.util.List;
import java.util.Map;

// please specify a postgres database in DatabaseConfiguration.getDatabase()

public class Main {
  public static void main(String[] args) {
    // setup
    // table "test_object" has 3 columns id, test_map_json, test_object_json
    TestObject testObject = new TestObject(
        "me",
        Map.of("field", List.of("a", "b", "c")),
        Map.of("field", List.of("a", "b", "c")));

    Database database = DatabaseConfiguration.getDatabase();

    try (Transaction transaction = database.beginTransaction()) {
      database.delete(TestObject.class, "me");
      database.save(testObject);
      transaction.commit();
    }

    // set test_map_json to a map of exactly the same value
    testObject = database.find(TestObject.class, "me");
    testObject.setTestMapJson(Map.of("field", List.of("a", "b", "c")));

    try (Transaction transaction = database.beginTransaction()) {
      database.save(testObject);
      transaction.commit();
    }

    // set test_object_json to a map of exactly the same value
    testObject = database.find(TestObject.class, "me");
    testObject.setTestObjectJson(Map.of("field", List.of("a", "b", "c")));

    try (Transaction transaction = database.beginTransaction()) {
      database.save(testObject);
      transaction.commit();
    }

    database.shutdown();
  }
}
