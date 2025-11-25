import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Translator translator = new Translator();

        translator.addWord("hello", "привіт");
        translator.addWord("world", "світ");
        translator.addWord("weather", "погода");
        translator.addWord("is", "є");
        translator.addWord("good", "хороша");
        translator.addWord("sun", "сонце");
        translator.addWord("shining", "світить");
        translator.addWord("the", "");

        System.out.println("Введіть A для заповнення словника або T для перекладу фрази");

        String choice = scanner.nextLine();
        boolean cont = true;

        while (cont) {
            if (choice.equalsIgnoreCase("A")) {
                System.out.println("- Заповнення словника -");
                System.out.println("Введіть пари слів. (T - перекладач, Q - вихід)");

                while (cont) {
                    System.out.print("Англійською: ");
                    String eng = scanner.nextLine();

                    if (eng.equalsIgnoreCase("T")) {
                        choice = "T";
                        break;
                    } else if (eng.equalsIgnoreCase("Q")) {
                        cont = false;
                        break;
                    }
                    System.out.print("Українською: ");
                    String ukr = scanner.nextLine();

                    translator.addWord(eng, ukr);
                    System.out.println("Слово додано!\n");
                }
            }
            else if (choice.equalsIgnoreCase("T")) {

                while (cont) {
                    System.out.println("\n- Перекладач -");
                    System.out.println("Введіть фразу англійською мовою. (A - заповнення словника, Q - вихід)");
                    String inputPhrase = scanner.nextLine();

                    if (inputPhrase.equalsIgnoreCase("A")) {
                        choice = "A";
                        break;
                    } else if (inputPhrase.equalsIgnoreCase("Q")) {
                        cont = false;
                        break;
                    }
                    String translation = translator.translate(inputPhrase);

                    System.out.println("Переклад: " + translation);
                }
            }
            else if (!choice.equalsIgnoreCase("Q")) {
                System.out.println("Невідома команда. Введіть A або T (або Q для виходу):");
                choice = scanner.nextLine();
                if (choice.equalsIgnoreCase("Q")) cont = false;
            }
        }
        scanner.close();
    }
}