package org.example;

public class TriangleFunction {

    public boolean checkSidesOfTriangle(Double a, Double b, Double c){
        if(a + b > c || a + c > b || c + b > a){
            return checkAreaOfTriangle(a, b, c);
        }else {
            return false;
        }
    }

    public boolean checkAreaOfTriangle(Double a, Double b, Double c) {
        double area = Math.sqrt(((a + b + c) / 2) * (((a + b + c) / 2) - a) * (((a + b + c) / 2) - b) * (((a + b + c) / 2) - c));
        if (area == 0) {
            return false;
        }else if(a < 0 || b < 0 || c < 0){
            return false;
        }else {
            return true;
        }
    }

    //Использовать формулу герона для расчета площади
    //перепесать попроще для использования функций

}
