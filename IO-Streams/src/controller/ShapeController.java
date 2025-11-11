package controller;

import model.ShapeModel;
import view.ShapeView;

public class ShapeController {

    private ShapeModel model;
    private ShapeView view;

    public ShapeController(){
        this.model = new ShapeModel();
        this.view = new ShapeView();
    }

    public void run(){

        view.displayShapes(model.getShapes());

        view.displayTotalArea(model.calculateTotalArea());

        view.displayTotalAreasByType(model.calculateTotalAreaByType());

        view.displayShapesByAreas(model.sortShapesByArea());

        view.displayShapesByColor(model.sortShapesByColor());

    }
}
