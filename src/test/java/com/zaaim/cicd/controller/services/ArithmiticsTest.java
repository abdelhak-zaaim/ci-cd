/*
 *  Copyright 2024 Abdelhak Zaaim
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 *  limitations under the License.
 */

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