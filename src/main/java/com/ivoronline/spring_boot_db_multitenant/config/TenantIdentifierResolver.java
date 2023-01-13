package com.ivoronline.spring_boot_db_multitenant.config;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.stereotype.Component;

@Component
public class TenantIdentifierResolver implements CurrentTenantIdentifierResolver {

  static final String DEFAULT_TENANT = "public";

  @Override
  public String resolveCurrentTenantIdentifier() {
    return "public";
  }

  @Override
  public boolean validateExistingCurrentSessions() {
    return true;
  }

}
