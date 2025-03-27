package ru.home.strategy.inputRootCrop;

import ru.home.model.RootCrop;
import ru.home.model.validator.DataValidator;
import ru.home.strategy.interfaces.DataInputStrategy;
import ru.home.util.CustomArrayList;

import java.util.Scanner;

public class ManualInputRootCrop implements DataInputStrategy<RootCrop> {
    private Scanner scanner;

    public ManualInputRootCrop(Scanner scanner) {
        this.scanner = scanner;
    }

    public CustomArrayList<RootCrop> inputData() {
        CustomArrayList<RootCrop> list = new CustomArrayList<>();
        System.out.println("Введите количество корнеплодов:");
        int count = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < count; i++) {

            RootCrop rootVegetable = new RootCrop.Builder().build().createFromInput(scanner);
            String type = rootVegetable.getType();
            double weight = rootVegetable.getWeight();
            String color = rootVegetable.getColor();

            if (DataValidator.validateVegetableData(type, weight, color)) {
            } else {
                System.out.println("Некорректные данные. Повторите ввод.");
                i--;
            }
        }
        return list;
    }

}
