package me.lenglet.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Scope(scopeName = AppRequestBeanFactoryPostProcessor.AppRequestScope.SCOPE_NAME, proxyMode = ScopedProxyMode.TARGET_CLASS)
public @interface AppRequestScope {
}
