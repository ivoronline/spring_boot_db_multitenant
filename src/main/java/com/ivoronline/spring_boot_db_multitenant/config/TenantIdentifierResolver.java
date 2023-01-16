package com.ivoronline.spring_boot_db_multitenant.config;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.stereotype.Component;

@Component
public class TenantIdentifierResolver implements CurrentTenantIdentifierResolver {

  static String currentTenant = "public";

  public void setCurrentTenant(String tenant) {
    currentTenant = tenant;
  }

  @Override
  public String resolveCurrentTenantIdentifier() {
    return currentTenant;
  }

  @Override
  public boolean validateExistingCurrentSessions() {
    return true;
  }

}
