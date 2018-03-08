package com.isa.jjdd.arquillian.ex01_junit;

import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Getter
@Setter
public class Postman {

    Set<Letter> postBag = Collections.emptySet();

    PostOffice postOffice = new PostOffice();

    void beginNewDay() {
        postBag = postOffice.preparePostBag();
    }

    Optional<Letter> findNextLetter(Optional<Letter> lastLetter) {
        if(postBag.isEmpty()) {
            return Optional.empty();
        }
        Letter nextLetter = postBag.iterator().next();
        postBag.remove(nextLetter);
        return Optional.ofNullable(nextLetter);
    }
}
