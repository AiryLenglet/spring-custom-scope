package me.lenglet.scope;

class AppRequestContextHolder {

    private static final ThreadLocal<AppRequestContext> appRequestContextThreadLocal = new ThreadLocal<>();

    public static AppRequestContext getContext() {
        return appRequestContextThreadLocal.get();
    }

    public static void initContext() {
        appRequestContextThreadLocal.set(new AppRequestContext());

    }

    public static void resetContext() {
        appRequestContextThreadLocal.remove();
    }
}
