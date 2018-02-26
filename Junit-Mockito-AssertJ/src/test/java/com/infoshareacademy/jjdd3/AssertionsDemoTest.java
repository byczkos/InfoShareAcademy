package com.infoshareacademy.jjdd3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class AssertionsDemoTest {
    @Test
    void twoShouldEqualTwo() {
        assertEquals(2, 2, "This should be something");
    }
}
