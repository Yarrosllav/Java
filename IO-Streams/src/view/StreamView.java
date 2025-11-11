package view;

import model.Shape;

public class StreamView {
    public void displayMenu() {
        System.out.println("1. Відобразити поточний набір фігур");
        System.out.println("2. Зберегти набір фігур у файл");
        System.out.println("3. Завантажити набір фігур з файлу");
        System.out.println("0. Повернутися до головного меню");
        System.out.print("Ваш вибір: ");
    }
    public void printMessage(String message) { System.out.println(message); }
    public void displayShapes(Shape[] shapes) {
        System.out.println("\n--- Поточний набір фігур ---");
        if (shapes == null || shapes.length == 0) {
            System.out.println("Набір порожній.");
            return;
        }
        for (Shape shape : shapes) {
            shape.draw();
        }
    }
}
