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
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.zaaim.cicd.services;

public class ComplexNumber {
    private final double real;
    private final double imag;

    public ComplexNumber(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public Double getReal() {
        return real;
    }

    public Double getImag() {
        return imag;
    }

    @Override
    public String toString() {
        if (real == 0 && imag == 0) return "0";
        StringBuilder b = new StringBuilder();
        if (real * imag != 0) b.append("(");
        if (real != 0) b.append(real);
        if (real * imag != 0) b.append(imag > 0 ? "+" : "").append(imag).append("i");
        else if (imag != 0) b.append(imag).append("i");
        if (real * imag != 0) b.append(")");

        return b.toString();
    }

    public static void main(String... args) {
        ComplexNumber cm1 = new ComplexNumber(2, 5);
        System.out.println(cm1);
        ComplexNumber cm2 = new ComplexNumber(0, 5);
        System.out.println(cm2);
        ComplexNumber cm3 = new ComplexNumber(2, 0);
        System.out.println(cm3);
        ComplexNumber cm4 = new ComplexNumber(0, 0);
        System.out.println(cm4);
    }
}
