package com.netflix.spinnaker.halyard.cli.command.v1.config.security.authn.ldap;

import com.netflix.spinnaker.halyard.cli.command.v1.config.security.authn.AuthnMethodCommand;
import com.netflix.spinnaker.halyard.config.model.v1.security.AuthnMethod;

public class LdapCommand extends AuthnMethodCommand {
  public AuthnMethod.Method getMethod() {
    return AuthnMethod.Method.LDAP;
  }

  public LdapCommand(){
    super();
    registerSubcommand(new EditLdapCommand());
  }

}
