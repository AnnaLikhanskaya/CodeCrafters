package ru.home.strategy.inputRootCrop;

import java.util.Scanner;
import ru.home.model.RootCrop;
import ru.home.strategy.interfaces.DataInputStrategy;
import ru.home.strategy.interfaces.Searchable;

import java.util.Random;

import static ru.home.model.validator.DataValidator.validateVegetableData;

public class ManualInputRootCrop implements DataInputStrategy<RootCrop>, Searchable<RootCrop> {

    Scanner scanner = new Scanner(System.in);
    CustomArrayList<RootCrop> rootCrops = new CustomArrayList<>();

    @Override
    public CustomArrayList<RootCrop> inputData() {
        System.out.println("Сколько собираетесь внести корнеплодов? Ведите число:");
        int  count = scanner.nextInt();

        for (int i = 0; i < count; i++) {
            rootCrops.add(createFromInput(scanner));
        }
        return rootCrops;
    }

    @Override
    public RootCrop createFromInput(Scanner scanner) {
        System.out.println("Введите тип корнеплода:");
        String type = scanner.next();
        System.out.println("Введите вес корнеплода:");
        while(!scanner.hasNextInt()){
            System.out.println("Введите числовое значение!");
        }
        int weight = scanner.nextInt();
        System.out.println("Введите цвет корнеплода:");
        String color = scanner.next();

        while(!validateVegetableData(type, weight, color)) {
            System.out.println("Введите правильные данные!");
            System.out.println("Вес должен бытьт больше нуля.");
            System.out.println("А тип и цвет не может быть пустой строкой.");
            System.out.println();
            System.out.println("Введите тип корнеплода:");
            type = scanner.next();
            System.out.println("Введите вес корнеплода:");
            while(!scanner.hasNextInt()){
                System.out.println("Введите числовое значение!");
            }
            weight = scanner.nextInt();
            System.out.println("Введите цвет корнеплода:");
            color = scanner.next();
        }
        scanner.close();
        return new RootCrop.Builder().type(type).weight(weight).color(color).build();
    }
}
