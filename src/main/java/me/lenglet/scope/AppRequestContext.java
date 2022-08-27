package me.lenglet.scope;

import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

class AppRequestContext {

    private final Map<String, Object> beans = new ConcurrentSkipListMap<>();

    public Object getBean(String beanName) {
        return beans.get(beanName);
    }

    public void registerBean(String s, Object bean) {
        this.beans.put(s, bean);
    }
}
