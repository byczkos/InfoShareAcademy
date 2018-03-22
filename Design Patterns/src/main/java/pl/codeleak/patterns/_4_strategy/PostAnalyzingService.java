package pl.codeleak.patterns._4_strategy;

class PostAnalyzingService {

    void analyzePost(Post post, String strategy) {
        PostAnalyzingStrategy postAnalyzingStrategy = PostAnalyzingStrategy.create(strategy);
        postAnalyzingStrategy.analyzePost(post);
    }
}
