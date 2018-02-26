package com.infoshareacademy.jjdd3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FirstJUnitTest {
    @Test
    public void firstTest() {
        assertTrue(true);
    }

    @Test
    public void secondTest() {
        assertFalse(false);
    }
}
