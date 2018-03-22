package pl.codeleak.patterns._1_builder;

import java.time.LocalDateTime;

class Account {

    private final String email;
    private final String password;

    private String name; // optional
    private LocalDateTime expiresAt; // optional


    private Account(String email, String password) {
        this.email = email;
        this.password = password;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getEmail() {
        return email;
    }

    String getPassword() {
        return password;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }

    public static CredentialsBuilder builder() {
        return new CredentialsBuilder();
    }

    static class CredentialsBuilder {
        Builder withCredentials(String email, String password) {
            return new Builder(email, password);
        }
    }

    static class Builder {

        private String email;
        private String password;
        private String name;
        private LocalDateTime expiresAt;

        public Builder(String email, String password) {
            this.email = email;
            this.password = password;
        }

        // TODO

        Account build() {
            Account account = new Account(this.email, this.password);
            account.setName(this.name);
            account.setExpiresAt(this.expiresAt);
            return account;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder expiresAt(LocalDateTime expiresAt) {
            this.expiresAt = expiresAt;
            return this;
        }
    }
}
