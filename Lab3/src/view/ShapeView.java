package view;

import model.Shape;
import java.util.Map;

public class ShapeView {

    public void displayShapes(Shape[] figures){
        System.out.println("\n --- Displaying All Shapes --- \n");
        for (Shape figure: figures){
            figure.draw();
        }
    }

    public void displayTotalArea(double totalArea){
        System.out.println("\n --- Displaying Total Area --- \n");
        System.out.println("Total Area of all figures is: " + totalArea);
    }

    public void displayTotalAreasByType(Map<String, Double> areasMap) {
        System.out.println("\n --- Displaying Total Area By Shape --- \n");
        for (Map.Entry<String, Double> entry : areasMap.entrySet()) {
            System.out.printf("Total Area for %s: %.2f%n", entry.getKey(), entry.getValue());
        }
    }

    public void displayShapesByAreas(Shape[] shapes){
        System.out.println("\n --- Displaying Shapes Sorted By Area --- \n");
        for (Shape figure: shapes){
            figure.draw();
        }
    }

    public void displayShapesByColor(Shape[] shapes){
        System.out.println("\n --- Displaying Shapes Sorted By Color --- \n");
        for (Shape figure: shapes){
            figure.draw();
        }
    }
}
