package com.makemake.springbasic20200524.scope;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

// if one of the dependency is prototype
// however if the bean using that is not a prototype
// we solving that using a proxy
@Component
@Scope(
        value = ConfigurableBeanFactory.SCOPE_PROTOTYPE,
        proxyMode = ScopedProxyMode.TARGET_CLASS
)
public class JdbcConnection {
    public JdbcConnection(){
        System.out.println("JDBC Connection");
    }
}
