package iostream;

import model.Shape;
import model.ShapeModel;
import java.io.IOException;
import java.util.*;

public class IOMain {

    private static ShapeModel shapeModel = new ShapeModel();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            printMainMenu();
            if (!scanner.hasNextInt()) {
                System.out.println("Будь ласка, введіть число.");
                scanner.next();
                continue;
            }
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> runTask1(scanner);
                case 2 -> runTask2();
                case 3 -> saveShapes(scanner);
                case 4 -> loadShapes(scanner);
                case 5 -> generateNewShapes();
                case 6 -> runTask3(scanner);
                case 7 -> runTask4(scanner);
                case 0 -> running = false;
                default -> System.out.println("Невірний вибір. Спробуйте ще раз.");
            }
        }
        System.out.println("Програму завершено.");
        scanner.close();
    }

    private static void printMainMenu() {
        System.out.println("\n--- МЕНЮ ---");
        System.out.println("1. Знайти рядок з макс. кількістю слів у файлі");
        System.out.println("2. Показати поточний набір фігур");
        System.out.println("3. Зберегти поточний набір фігур у файл");
        System.out.println("4. Завантажити набір фігур з файлу");
        System.out.println("5. Згенерувати новий випадковий набір фігур");
        System.out.println("6. Шифрування / Дешифрування файлу");
        System.out.println("7. Порахувати частоту тегів за url");
        System.out.println("0. Вихід");
        System.out.print("Оберіть опцію: ");
    }


    private static void runTask1(Scanner scanner) {
        System.out.print("\nВведіть повний шлях до файлу: ");
        String filePath = scanner.nextLine();
        try {
            String result = LineReader.findLine(filePath);
            System.out.println(result != null ? "Знайдений рядок: " + result : "Файл порожній.");
        } catch (IOException e) {
            System.err.println("Помилка читання файлу: " + e.getMessage());
        }
    }

    private static void runTask2() {
        System.out.println("\nПоточний набір фігур: ");
        Shape[] shapes = shapeModel.getShapes();
        for(Shape shape: shapes) {
            System.out.println(shape);
        }
    }

    private static void saveShapes(Scanner scanner) {
        System.out.print("\nВведіть ім'я файлу для збереження: ");
        String filename = scanner.nextLine();
        try {
            ShapeSaver.saveShapes(shapeModel.getShapes(), filename);
            System.out.println("Дані успішно збережено у файл " + filename);
        } catch (IOException e) {
            System.err.println("Помилка збереження файлу: " + e.getMessage());
        }
    }

    private static void loadShapes(Scanner scanner) {
        System.out.println("\nВведіть ім'я файлу для завантаження: ");
        Shape[] loadedShapes;
        String filename = scanner.nextLine();
        try {
            loadedShapes =  ShapeSaver.loadShapes(filename);
            System.out.println("Дані успішно завантажено. Поточний набір фігур оновлено.");
            for(Shape shape: loadedShapes) {
                System.out.println(shape);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Помилка завантаження файлу: " + e.getMessage());
        }
    }

    private static void generateNewShapes() {
        shapeModel = new ShapeModel();
        System.out.println("\nСтворено новий випадковий набір фігур.");
    }

    private static void runTask3(Scanner scanner) {
        try {
            System.out.print("\nВведіть шлях до вхідного файлу: ");
            String inputFile = scanner.nextLine();
            System.out.print("Введіть шлях для зашифрованого файлу: ");
            String encryptedFile = scanner.nextLine();
            System.out.print("Введіть шлях для дешифрованого файлу: ");
            String decryptedFile = scanner.nextLine();
            System.out.print("Введіть ключовий символ (напр., 'S'): ");
            String key = scanner.nextLine();

            if (key.isEmpty()) {
                System.err.println("Помилка: порожній ключ");
                return;
            }

            Crypter.encrypt(inputFile, encryptedFile, key);
            System.out.println("Файл успішно зашифровано в " + encryptedFile);

            Crypter.decrypt(encryptedFile, decryptedFile, key);
            System.out.println("Файл успішно дешифровано в " + decryptedFile);

        } catch (IOException e) {
            System.err.println("Сталася помилка вводу/виводу: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Сталася помилка: " + e.getMessage());
        }
    }

    private static void runTask4(Scanner scanner) {
        System.out.print("\nВведіть URL сторінки: ");
        String url = scanner.nextLine();
        try {
            Map<String, Integer> frequencies = TagCounter.countTags(url);

            System.out.println("\nРезультати в алфавітному порядку");
            new TreeMap<>(frequencies).forEach((tag, count) -> System.out.printf("Тег: %-10s | Частота: %d%n", tag, count));

            System.out.println("\nРезультати в порядку зростання частоти");
            List<Map.Entry<String, Integer>> list = new ArrayList<>(frequencies.entrySet());
            list.sort(Map.Entry.comparingByValue());
            list.forEach(entry -> System.out.printf("Тег: %-10s | Частота: %d%n", entry.getKey(), entry.getValue()));

        } catch (Exception e) {
            System.err.println("Помилка обробки URL: " + e.getMessage());
        }
    }

}
