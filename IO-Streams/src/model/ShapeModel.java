package model;

import java.util.*;

public class ShapeModel {
    private Shape[] shapes;


    public ShapeModel() {
        initializeShapes();
    }

    private void initializeShapes() {
        shapes = new Shape[12];

        String[] colors = {"Red", "Green", "Blue", "Yellow", "Black", "White"};
        Random random = new Random();

        for (int i = 0; i < shapes.length; i++) {
            int randomShapeType = random.nextInt(3); // 0 - Rect, 1 - Triang, 3 - Circle
            String randomColor = colors[random.nextInt(colors.length)];

            double rawVal1 = random.nextDouble(1.0, 15.0);
            double rawVal2 = random.nextDouble(1.0, 15.0);

            double randomVal1 = Math.round(rawVal1 * 1000.0) / 1000.0;
            double randomVal2 = Math.round(rawVal2 * 1000.0) / 1000.0;

            switch (randomShapeType) {
                case 0 -> shapes[i] = new Rectangle(randomColor, randomVal1, randomVal2);
                case 1 -> shapes[i] = new Triangle(randomColor, randomVal1, randomVal2);
                case 2 -> shapes[i] = new Circle(randomColor, randomVal1);
            }
        }
    }


    public Shape[] getShapes() {
        return shapes;
    }

    public void setShapes(Shape[] shapes) {
        this.shapes = shapes;
    }

    public double calculateTotalArea() {
        double totalArea = 0.0;
        for (Shape shape : shapes) {
            totalArea += shape.calcArea();
        }
        return Math.round(totalArea * 1000.0) / 1000.0;
    }


    public Map<String, Double> calculateTotalAreaByType() {
        Map<String, Double> areasMap = new HashMap<>();

        for (Shape shape : shapes) {
            String shapeType = shape.getClass().getSimpleName();

            double currentArea = shape.calcArea();

            areasMap.merge(shapeType, currentArea, Double::sum);
        }

        return areasMap;
    }


    public Shape[] sortShapesByArea() {
        Shape[] copyShapes = shapes.clone();
        Arrays.sort(copyShapes, new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2) {
                return Double.compare(o1.calcArea(), o2.calcArea());
            }
        });
        return copyShapes;
    }

    public Shape[] sortShapesByColor() {
        Shape[] copyShapes = shapes.clone();
        Arrays.sort(copyShapes, new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2) {
                return o1.getShapeColor().compareTo(o2.getShapeColor());
            }
        });
        return copyShapes;
    }
}


