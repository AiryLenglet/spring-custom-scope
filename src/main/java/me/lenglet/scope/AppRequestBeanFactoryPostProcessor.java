package me.lenglet.scope;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.context.annotation.Configuration;

import static me.lenglet.scope.AppRequestBeanFactoryPostProcessor.AppRequestScope.SCOPE_NAME;

@Configuration
class AppRequestBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory factory) throws BeansException {
        factory.registerScope(SCOPE_NAME, new AppRequestScope());
    }

    public static class AppRequestScope implements Scope {

        public static final String SCOPE_NAME = "app-request";

        @Override
        public Object get(String s, ObjectFactory<?> objectFactory) {
            final var context = AppRequestContextHolder.getContext();
            var bean = context.getBean(s);
            if (bean == null) {
                bean = objectFactory.getObject();
                context.registerBean(s, bean);
            }
            return bean;
        }

        @Override
        public Object remove(String s) {
            return null;
        }

        @Override
        public void registerDestructionCallback(String s, Runnable runnable) {
            int i = 0;
            i++;
        }

        @Override
        public Object resolveContextualObject(String s) {
            return null;
        }

        @Override
        public String getConversationId() {
            return null;
        }
    }

}
