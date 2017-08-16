package com.netflix.spinnaker.halyard.config.model.v1.security;

import com.netflix.spinnaker.halyard.config.model.v1.node.Validator;
import com.netflix.spinnaker.halyard.config.problem.v1.ConfigProblemSetBuilder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Ldap extends AuthnMethod{

  private final Method method = Method.LDAP;
  private final String nodeName = "ldap";

  private String url;
  private String userDnPattern;
  private String userSearchBase;
  private String userSearchFilter;

  @Override
  public void accept(ConfigProblemSetBuilder psBuilder, Validator v){
    v.validate(psBuilder, this);
  }
}
