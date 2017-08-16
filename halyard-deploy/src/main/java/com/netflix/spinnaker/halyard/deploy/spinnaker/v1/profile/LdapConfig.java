package com.netflix.spinnaker.halyard.deploy.spinnaker.v1.profile;


import com.netflix.spinnaker.halyard.config.model.v1.security.Ldap;
import com.netflix.spinnaker.halyard.config.model.v1.security.Security;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class LdapConfig {
  boolean enabled;

  String url;
  String userDnPattern;
  String userSearchBase;
  String userSearchFilter;

  public LdapConfig(Security security) {
    if (!security.getAuthn().getLdap().isEnabled()) {
      return;
    }

    Ldap ldap = security.getAuthn().getLdap();

    this.enabled = ldap.isEnabled();
    this.url = ldap.getUrl();
    this.userDnPattern = ldap.getUserDnPattern();
    this.userSearchBase = ldap.getUserSearchBase();
    this.userSearchFilter = ldap.getUserSearchFilter();
  }
}
