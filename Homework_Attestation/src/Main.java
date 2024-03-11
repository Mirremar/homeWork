//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Notebook.initialize();
        while(true)
        {
            System.out.println("Выберите вариант действий:\n" +
                "1 — Посмотреть имеющиеся ноутбуки\n" +
                "2 — Добавить ноутбук\n" +
                "3 — Поиск ноутбука по критериям\n" +
                "4 — Выход из программы\n");
            Scanner sc = new Scanner(System.in);
            switch (Integer.parseInt(sc.next())) {
                case 1:
                {
                    System.out.println("Будут выведены предварительно сгенерированные ноутбуки");
                    for (Notebook n : Notebook.notebooks)
                    {
                        System.out.println(n);
                    }
                    break;

                }
            case 2: {
                Notebook.noteAdd();
                System.out.println("Ноутбук добавлен в коллекцию");
                break;
            }
            case 3: {
                HashMap<Integer,String> filters = Notebook.criteriaReader();
                Notebook.noteSearch(filters);
                if (Notebook.filteredNotebooks.isEmpty())
                {
                    System.out.println("Таких ноутбуков нет");
                }
                else {
                    for (Notebook item : Notebook.filteredNotebooks) {
                        System.out.println(item);
                    }
                }
                Notebook.filteredNotebooks.addAll(Notebook.notebooks);
                break;
            }
            case 4: {
                System.out.println("Программа завершила работу");
                System.exit(0);
            }
            default: {
                System.out.println("Введено некорректное значение.Пожалуйста,повторите ввод");
            }
            }


        }

    }
}