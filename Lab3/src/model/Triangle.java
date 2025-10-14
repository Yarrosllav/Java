package model;

public class Triangle extends Shape{

    private double baseWidth;
    private double height;

    public Triangle(String shapeColor, double baseWidth, double height) {
        super(shapeColor);
        this.baseWidth = baseWidth;
        this.height = height;
    }

    @Override
    public double calcArea() {
        return Math.round((baseWidth * height) / 2 * 1000.0) / 1000.0;
    }

    @Override
    public String toString() {
        return "/\\ Triangle, " + super.toString() + ", base width = " + baseWidth + ", height = " + height;
    }
}
