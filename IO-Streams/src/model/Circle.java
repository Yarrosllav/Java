package model;


import java.io.Serializable;

public class Circle extends Shape implements Serializable {

    private double radius;

    public Circle(String shapeColor, double radius) {
        super(shapeColor);
        this.radius = radius;
    }


    @Override
    public double calcArea() {
        return Math.round(Math.PI * radius * radius * 1000.0) / 1000.0;
    }

    @Override
    public String toString() {
        return "() Circle, " + super.toString() + ", radius = " + radius;
    }
}
