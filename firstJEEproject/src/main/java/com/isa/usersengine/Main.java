package com.isa.usersengine;

import com.isa.usersengine.dao.UsersRepositoryDaoBean;


public class Main {

    public static void main(String[] args) {
        System.out.println("Hello Word\n");

        //UsersRepositoryDao usersRepositoryDao = new UsersRepositoryDaoBean();
        // tworzymy obiekt o nazwie i obiekcie zgodnym z implementowanym interfejsem, ale po slowie new
        // wywolujemy obiekt typu klasy implemenujacej interfejs !!!

        new UsersRepositoryDaoBean()
                .getUserList()
                .forEach(s -> System.out.println(s.getName()+" "+s.getLogin()));
        }
    }

