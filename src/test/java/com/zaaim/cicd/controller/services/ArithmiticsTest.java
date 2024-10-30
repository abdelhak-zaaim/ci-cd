package com.zaaim.cicd.controller.services;

import org.junit.jupiter.api.Test;

public class ArithmiticsTest {
   @Test
    public void testAdd() {
        int a = 1;
        int b = 2;
        int result = Arithmitics.add(a, b);
        assert result == 3;
    }
}
