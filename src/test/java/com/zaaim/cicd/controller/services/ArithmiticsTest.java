package com.zaaim.cicd.controller.services;

import com.zaaim.cicd.services.Arithmitics;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArithmiticsTest {

    @Test
    public void testAdd() {
        int a = 1;
        int b = 2;
        int result = Arithmitics.add(a, b);
        assertEquals(3, result);
    }

    @Test
    public void testAddWithNegativeNumbers() {
        int a = -1;
        int b = -2;
        int result = Arithmitics.add(a, b);
        assertEquals(-3, result);
    }

    @Test
    public void testAddWithZero() {
        int a = 0;
        int b = 0;
        int result = Arithmitics.add(a, b);
        assertEquals(0, result);
    }
}