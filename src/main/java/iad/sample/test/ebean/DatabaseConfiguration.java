package iad.sample.test.ebean;

import io.ebean.Database;
import io.ebean.DatabaseFactory;
import io.ebean.config.DatabaseConfig;
import io.ebean.datasource.DataSourceConfig;

public class DatabaseConfiguration {
  private DatabaseConfiguration() {}

  public static Database getDatabase() {
    DataSourceConfig dataSourceConfig = new DataSourceConfig();
    // please specify a postgres database to run
    dataSourceConfig.setUsername("");
    dataSourceConfig.setPassword("");
    dataSourceConfig.setUrl("");

    DatabaseConfig config = new DatabaseConfig();
    config.setDataSourceConfig(dataSourceConfig);

    return DatabaseFactory.create(config);
  }
}
