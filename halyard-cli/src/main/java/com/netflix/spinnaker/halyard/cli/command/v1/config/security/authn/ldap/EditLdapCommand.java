package com.netflix.spinnaker.halyard.cli.command.v1.config.security.authn.ldap;

import com.beust.jcommander.Parameter;
import com.netflix.spinnaker.halyard.cli.command.v1.config.security.authn.AbstractEditAuthnMethodCommand;
import com.netflix.spinnaker.halyard.config.model.v1.security.AuthnMethod;
import com.netflix.spinnaker.halyard.config.model.v1.security.Ldap;
import lombok.Getter;

public class EditLdapCommand extends AbstractEditAuthnMethodCommand<Ldap> {

  @Getter
  private String shortDescription = "Configure authentication using a LDAP identity provider.";

  @Getter
  private String longDescription = String.join(" ", "placeholder text...markus says fix this.");

  @Getter
  private AuthnMethod.Method method = AuthnMethod.Method.LDAP;

  @Parameter(
      names = "--url",
      description = "ldap:// or ldaps:// url of the LDAP server"
  )
  private String url;

  @Parameter(
      names = "--user-dn-pattern",
      description = "Placeholder...uid={0},ou=users"
  )
  private String userDnPattern;

  @Parameter(
      names = "--user-search-base",
      description = "Placeholder..."
  )
  private String userSearchBase;

  @Parameter(
      names = "--user-search-filter",
      description = "Placeholder"
  )
  private String userSearchFilter;



  @Override
  protected AuthnMethod editAuthnMethod(Ldap ldap) {
    ldap.setUrl(isSet(url) ? url : ldap.getUrl());
    ldap.setUserDnPattern(isSet(userDnPattern) ? userDnPattern : ldap.getUserDnPattern());
    ldap.setUserSearchBase(isSet(userSearchBase) ? userSearchBase : ldap.getUserSearchBase());
    ldap.setUserSearchFilter(isSet(userSearchFilter) ? userSearchFilter : ldap.getUserSearchFilter());

    if (isSet(userSearchBase)) {
      if (userSearchBase.isEmpty()) {
        ldap.setUserSearchBase(null);
      }
    }

    if (isSet(userSearchFilter)) {
      if (userSearchFilter.isEmpty()) {
        ldap.setUserSearchFilter(null);
      }
    }

    return ldap;
  }

}
