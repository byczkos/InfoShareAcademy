package com.isa.usersengine.dao;

import com.isa.usersengine.domain.User;
import com.isa.usersengine.interceptors.AddUserInterceptor;
import com.isa.usersengine.interceptors.LogInterceptor;
import com.isa.usersengine.repository.UsersRepository;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import java.util.List;

@Stateless
public class UsersRepositoryDaoBean implements UsersRepositoryDao {

    @Override
    @Interceptors({AddUserInterceptor.class, LogInterceptor.class})
    public void addUser(User user) {
        UsersRepository.getRepository().add(user);
    }

    @Override
    public User getUserById(int id) {
        for(User user : UsersRepository.getRepository()) {
            if(user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User getUserByLogin(String login) {
        for (User user: UsersRepository.getRepository()) {
            if(user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> getUserList() {
        return UsersRepository.getRepository();
    }
}
