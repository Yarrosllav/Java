package model;

public abstract class Shape implements Drawable {
    protected String shapeColor;

    public Shape(String shapeColor){
        this.shapeColor = shapeColor;
    }

    public abstract double calcArea();

    @Override
    public String toString() {
        return "Shape color is: " + shapeColor;
    }

    @Override
    public void draw() {
        System.out.println(toString() + ", area is: " + calcArea());
    }

    public String getShapeColor() {
        return shapeColor;
    }
}
