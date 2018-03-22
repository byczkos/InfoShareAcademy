package pl.codeleak.patterns._4_strategy;

class PostSharingApp {

    public static void main(String[] args) {
        Post post = Post.newPost("Post 1");
        PostAnalyzingService postAnalyzingService = new PostAnalyzingService();

        postAnalyzingService
                .analyzePost(post, "quick");

        postAnalyzingService
                .analyzePost(post, "strict");

        postAnalyzingService
                .analyzePost(post, "balanced");
    }
}
