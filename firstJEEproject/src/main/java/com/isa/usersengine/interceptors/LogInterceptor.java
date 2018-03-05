package com.isa.usersengine.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import java.util.logging.Logger;

public class LogInterceptor {
    Logger LOG = Logger.getLogger(AddUserInterceptor.class.getName());

    @AroundInvoke
    public Object intercept(InvocationContext context) throws Exception {
        LOG.info("Add user has been invoked!");
        return context.proceed();
    }
}
