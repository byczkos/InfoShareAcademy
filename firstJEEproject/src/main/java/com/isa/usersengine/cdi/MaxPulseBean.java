package com.isa.usersengine.cdi;

import com.isa.usersengine.dao.UsersRepositoryDao;
import com.isa.usersengine.domain.User;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class MaxPulseBean {


    public double maxWomenPulse(int age) {
        double pulse = 216 - (1.09*age);
        return pulse;
    }

    public double maxMenPulse(int age) {
        double pulse = 202 - (0.55*age);
        return pulse;
    }
}
