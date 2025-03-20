package ru.home;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        CustomArrayList<Integer> arrayList = new CustomArrayList<>();

        
        while (true) {
            System.out.println("Приветсвуем Вас в приложении сортировки!");
            System.out.println("Выберете действие:");
            System.out.println("1. Заполнить массив из файла");
            System.out.println("2. Заполнить массив случайными числами");
            System.out.println("3. Заполнить массив вручную");
            System.out.println("4. Выполнить бинарный поиск");
            System.out.println("5. Выход");

            int chois = scanner.nextInt();

            switch (chois) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:
                    System.out.println("Завершение работы. Всего хорошего!");
                    return;
                default:
                    System.out.println("Неизвестная команда! Попробуйте снова.");
            }
        }
    }
}