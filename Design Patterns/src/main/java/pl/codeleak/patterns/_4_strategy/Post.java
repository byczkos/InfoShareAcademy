package pl.codeleak.patterns._4_strategy;

final class Post {

    private String message;

    private Post(String message) {
        this.message = message;
    }

    String getMessage() {
        return message;
    }

    static Post newPost(String message) {
        return new Post(message);
    }
}
