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

    public ComplexNumber(double real) {
        this.real = real;
        this.imag = 0;
    }

    public Double getReal() {
        return real;
    }

    public Double getImag() {
        return imag;
    }

    public ComplexNumber multiply(ComplexNumber cm){
        double real = this.real * cm.real - this.imag * cm.imag;
        double imag = this.real * cm.imag + this.imag * cm.real;
        return new ComplexNumber(real, imag);
    }

    public ComplexNumber add(ComplexNumber cm){
        double real = this.real + cm.real;
        double imag = this.imag + cm.imag;
        return new ComplexNumber(real, imag);
    }

    public ComplexNumber subtract(ComplexNumber cm){
        double real = this.real - cm.real;
        double imag = this.imag - cm.imag;
        return new ComplexNumber(real, imag);
    }

    public ComplexNumber divide(ComplexNumber cm){
        double denominator = cm.real * cm.real + cm.imag * cm.imag;
        double real = (this.real * cm.real + this.imag * cm.imag) / denominator;
        double imag = (this.imag * cm.real - this.real * cm.imag) / denominator;
        return new ComplexNumber(real, imag);
    }

    public ComplexNumber conjugate(){
        return new ComplexNumber(real, -imag);
    }

    public double abs(){
        return Math.sqrt(real * real + imag * imag);
    }

    public ComplexNumber square(){
        return multiply(this);
    }

    public ComplexNumber sqrt(){
        double r = Math.sqrt((Math.sqrt(real * real + imag * imag) + real) / 2);
        double i = Math.signum(imag) * Math.sqrt((Math.sqrt(real * real + imag * imag) - real) / 2);
        return new ComplexNumber(r, i);
    }

    public ComplexNumber pow(int n){
        ComplexNumber result = new ComplexNumber(1, 0);
        for (int i = 0; i < n; i++){
            result = result.multiply(this);
        }
        return result;
    }

    public ComplexNumber exp(){
        double r = Math.exp(real) * Math.cos(imag);
        double i = Math.exp(real) * Math.sin(imag);
        return new ComplexNumber(r, i);
    }

    public ComplexNumber sin(){
        double r = Math.sin(real) * Math.cosh(imag);
        double i = Math.cos(real) * Math.sinh(imag);
        return new ComplexNumber(r, i);
    }

    public ComplexNumber cos(){
        double r = Math.cos(real) * Math.cosh(imag);
        double i = -Math.sin(real) * Math.sinh(imag);
        return new ComplexNumber(r, i);
    }

    public ComplexNumber tan(){
        return sin().divide(cos());
    }

    public ComplexNumber sinh(){
        double r = Math.sinh(real) * Math.cos(imag);
        double i = Math.cosh(real) * Math.sin(imag);
        return new ComplexNumber(r, i);
    }

    public ComplexNumber cosh(){
        double r = Math.cosh(real) * Math.cos(imag);
        double i = Math.sinh(real) * Math.sin(imag);
        return new ComplexNumber(r, i);
    }

    public ComplexNumber tanh(){
        return sinh().divide(cosh());
    }

    public ComplexNumber asin(){
        return this.multiply(this).subtract(new ComplexNumber(1, 0)).sqrt().add(this.multiply(new ComplexNumber(0, 1))).log().multiply(new ComplexNumber(0, 1));
    }

    public ComplexNumber acos(){
        return this.multiply(this).subtract(new ComplexNumber(1, 0)).sqrt().add(this).multiply(new ComplexNumber(0, 1)).log().multiply(new ComplexNumber(0, -1));
    }

    public ComplexNumber atan(){
        return new ComplexNumber(0, 1).add(this).divide(new ComplexNumber(0, 1).subtract(this)).log().multiply(new ComplexNumber(0, 0.5));
    }

    public ComplexNumber log(){
        return new ComplexNumber(Math.log(abs()), Math.atan2(imag, real));
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

}
