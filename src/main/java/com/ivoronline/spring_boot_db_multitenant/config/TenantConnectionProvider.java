package com.ivoronline.spring_boot_db_multitenant.config;

import org.hibernate.cfg.AvailableSettings;
import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Component
public class TenantConnectionProvider implements MultiTenantConnectionProvider {

  private DataSource datasource;

  @Bean
  public HibernatePropertiesCustomizer tenantConnectionProviderCustomizer(TenantConnectionProvider tenantConnectionProvider) {
    return hibernateProperties -> {
      hibernateProperties.put(AvailableSettings.MULTI_TENANT_CONNECTION_PROVIDER, tenantConnectionProvider);
    };
  }
  public TenantConnectionProvider(DataSource dataSource) {
    this.datasource = dataSource;
  }

  @Override
  public Connection getAnyConnection() throws SQLException {
    return datasource.getConnection();
  }

  @Override
  public void releaseAnyConnection(Connection connection) throws SQLException {
    connection.close();
  }

  @Override
  public Connection getConnection(String tenantIdentifier) throws SQLException {
    final Connection connection = getAnyConnection();
    connection.createStatement().execute(String.format("SET SCHEMA '%s';", tenantIdentifier));
    //connection.createStatement().execute("SET Schema 'ivor1'");
    return connection;
  }

  @Override
  public void releaseConnection(String tenantIdentifier, Connection connection) throws SQLException {
    //connection.createStatement().execute(String.format("SET SCHEMA \"%s\";", TenantIdentifierResolver.DEFAULT_TENANT));
    connection.createStatement().execute("SET Schema 'public'");
    releaseAnyConnection(connection);
  }
  @Override
  public boolean supportsAggressiveRelease() { return false; }

  @Override
  public boolean isUnwrappableAs(Class unwrapType) { return false; }

  @Override
  public <T> T unwrap(Class<T> unwrapType) { return null; }

}
