import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static String scanner;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            operationSelection(scan);
            if (scanner.equalsIgnoreCase("end")) {
                listDisplay(list);
                break;
            } else {
                switch (scanner) {
                    case ("1"): {
                        listCreation(scan, list);
                        break;
                    }
                    case ("2"): {
                        listDisplay(list);
                        break;
                    }
                    case ("3"): {
                        deleteItem(scan, list);
                        listDisplay(list);
                        break;
                    }
                    case ("4"): {
                        searchInTheList(scan, list);
                        break;
                    }

                }
            }
        }
    }

    private static void operationSelection(Scanner scan) {
        System.out.println("\n Список покупок!");
        System.out.println("""
                Введите номер операции или "end" для завершения:\s
                1. Добавить покупку в список.\s
                2. Показать список покупок.\s
                3. Удалить покупку из списка.\s
                4. Найти покупку.""");
        scanner = scan.nextLine();
    }

    private static void deleteItem(Scanner scan, ArrayList<String> list) {
        System.out.println("Какой пункт из списка вы хотите удалить? Введите номер или название:");
        listDisplay(list);
        scanner = scan.nextLine();
        try {
            list.remove(Integer.parseInt(scanner) - 1);
        } catch (NumberFormatException e) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).equalsIgnoreCase(scanner)) {
                    list.remove(i);

                }
            }
        }
        System.out.println("Этот пункт удален из списка! \n");
    }

    private static void listCreation(Scanner scan, ArrayList<String> list) {
        System.out.println("Введите название покупки:");
        scanner = scan.nextLine();
        list.add(scanner);
        System.out.println("Итого в списке покупок: " + list.size());
    }

    public static void listDisplay(ArrayList<String> list) {
        System.out.println("Ваш список :");
        for (String i : list) {
            System.out.println(list.indexOf(i) + 1 + ". " + i);
        }
    }

    private static void searchInTheList(Scanner scan, ArrayList<String> list) {
        System.out.println("Какой пункт покупок хотите найти? Введите номер или название:");
        scanner = scan.nextLine();
        try {
            System.out.println("Пункт покупки найден! \n" + scanner + ". " + list.get(Integer.parseInt(scanner) - 1));
        } catch (NumberFormatException e) {
            String itemLower;
            String queryLower = scanner.toLowerCase();
            for (int i = 0; i < list.size(); i++) {
                itemLower = list.get(i).toLowerCase();
                if (itemLower.contains(queryLower)) {
                    System.out.println((list.indexOf(list.get(i)) + 1) + ". " + list.get(i));
                }
            }
        }
    }
}