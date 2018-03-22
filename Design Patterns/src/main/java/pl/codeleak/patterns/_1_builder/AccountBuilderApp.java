package pl.codeleak.patterns._1_builder;

import java.time.LocalDateTime;

public class AccountBuilderApp {

    public static void main(String[] args) {
        // TODO Create a builder that constructs different account representations: one with only required fields set, second with optional name set too, and the third with all fields set

//        Account accountOne = new Account("email@example.com", "123");
//        accountOne.setName("John");
//        accountOne.setExpiresAt(LocalDateTime.now().plusHours(24));

        Account accountOne = Account.builder()
                .withCredentials("email@example.com", "123")
                .build();

        Account accountTwo = Account.builder()
                .withCredentials("email@example.com", "123")
                .withName("John")
                .build();

        Account accountThree = Account.builder()
                .withCredentials("email@example.com", "123")
                .withName("John")
                .expiresAt(LocalDateTime.now().plusHours(16))
                .build();
    }
}

