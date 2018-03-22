package pl.codeleak.patterns._4_strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@FunctionalInterface
interface PostAnalyzingStrategy {

    Logger LOG = LoggerFactory.getLogger(PostAnalyzingStrategy.class);

    void analyzePost(Post post);

    // TODO Factory
    static PostAnalyzingStrategy create(String name) {
        switch (name) {
            case "quick":
                return post -> System.out.println("Quick strategy");
            case "strict":
                return post -> System.out.println("Strict strategy");
            case "balanced":
                return post -> System.out.println("Balanced strategy");
            default:
                throw new IllegalArgumentException("no strategy found");

        }

    }
}

