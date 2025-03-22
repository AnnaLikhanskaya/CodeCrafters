package main.java.ru.home.utill.strategy.inputrootvegetable;

import main.java.ru.home.utill.CustomArrayList;
import main.java.ru.home.utill.model.RootVegetable;
import main.java.ru.home.utill.strategy.interfaces.DataInputStrategy;

import java.util.Scanner;

public class ManualInputRootVegetable implements DataInputStrategy<RootVegetable> {
    private final Scanner scanner;

    public ManualInputRootVegetable(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public CustomArrayList<RootVegetable> inputData() {
        CustomArrayList<RootVegetable> list = new CustomArrayList<>();
        System.out.println("Введите количество корнеплодов:");
        int count = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < count; i++) {
            System.out.println("Введите тип корнеплода:");
            String type = scanner.nextLine();

            System.out.println("Введите вес корнеплода:");
            double weight = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("Введите цвет корнеплода:");
            String color = scanner.nextLine();

            RootVegetable rootVegetable = new RootVegetable.Builder()
                    .type(type)
                    .weight(weight)
                    .color(color)
                    .build();
            list.add(rootVegetable);
        }

        return list;
    }
}