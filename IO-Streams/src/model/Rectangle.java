package model;

import model.Shape;

import java.io.Serializable;

public class Rectangle extends Shape implements Serializable {

    private double width;
    private double height;

    public Rectangle(String shapeColor, double width, double height) {
        super(shapeColor);
        this.width = width;
        this.height = height;
    }


    @Override
    public double calcArea() {
        return Math.round(width * height * 1000.0) / 1000.0;
    }

    @Override
    public String toString() {
        return "[] Rectangle, " + super.toString() + ", width = " + width + ", height = " + height;
    }
}
