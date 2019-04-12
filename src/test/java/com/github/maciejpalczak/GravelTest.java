package com.github.maciejpalczak;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

@Ignore
public class GravelTest {
    Gravel gravel = new Gravel((long) 5, 2.5);

    @Test
    public void shouldCheckWeight() {
        assertTrue(gravel.getWeight() == (long) 5);
    }

    @Test
    public void shouldCheckWidth() {
        assertTrue(gravel.getWidth() == (2.5));
    }

}
