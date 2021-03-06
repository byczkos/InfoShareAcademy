package com.isa.usersengine.interceptors;

import com.isa.usersengine.dao.UsersRepositoryDaoBean;
import com.isa.usersengine.domain.Gender;
import com.isa.usersengine.domain.User;
import com.isa.usersengine.repository.UsersRepository;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import java.util.logging.Logger;

public class AddUserInterceptor {

    Logger LOG = Logger.getLogger(AddUserInterceptor.class.getName());
    
    @AroundInvoke
    public Object intercept(InvocationContext context) throws Exception {
    Object[] parameters = context.getParameters();
        for (Object parameter: parameters) {
            User user = (User) parameter;
            if(user.getGender() == null) {
                if(user.getName().endsWith("a")) {
                    user.setGender(Gender.WOMEN);
                } else {
                    user.setGender(Gender.MAN);    
                }
            }
            LOG.info("Gender interceptor: Gender has been set to: "+ user.getGender().toString());            
        }
        context.setParameters(parameters);
        return context.proceed();
    }
}
