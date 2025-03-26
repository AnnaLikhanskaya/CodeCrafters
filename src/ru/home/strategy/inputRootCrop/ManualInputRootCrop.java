package ru.home.strategy.inputRootCrop;

import java.util.Scanner;
import ru.home.model.RootCrop;
import ru.home.strategy.interfaces.DataInputStrategy;
import ru.home.strategy.interfaces.Searchable;

import java.util.Random;

import static ru.home.model.validator.DataValidator.validateVegetableData;

public class ManualInputRootCrop implements DataInputStrategy<RootCrop> {

    Scanner scanner = new Scanner(System.in);
    CustomArrayList<RootCrop> rootCrops = new CustomArrayList<>();

    @Override
    public CustomArrayList<RootCrop> inputData() {
        System.out.println("Сколько собираетесь внести корнеплодов? Ведите число:");
        while(!scanner.hasNextInt()){
            System.out.println("Введите числовое значение!");
        }
        int  count = scanner.nextInt();

        for (int i = 0; i < count; i++) {
            rootCrops.add(new RootCrop.Builder().build().createFromInput(scanner));
        }
        return rootCrops;
    }

}
