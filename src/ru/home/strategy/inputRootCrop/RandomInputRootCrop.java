package ru.home.strategy.inputRootCrop;


import ru.home.model.RootCrop;
import ru.home.strategy.interfaces.DataInputStrategy;
import ru.home.util.CustomArrayList;

import java.util.Random;

public class RandomInputRootCrop implements DataInputStrategy<RootCrop> {

    private final Random random;

    public RandomInputRootCrop() {
        this.random = new Random();
    }

    @Override
    public CustomArrayList<RootCrop> inputData() {
        CustomArrayList<RootCrop> list = new CustomArrayList<>();

        int count = random.nextInt(10) + 1;

        for (int i = 0; i < count; i++) {
            String[] types = {"Carrot", "Potato", "Beet", "Radish", "Turnip"};
            String type = types[random.nextInt(types.length)];

            int weight = random.nextInt(451) + 50;

            String[] colors = {"Orange", "Brown", "Purple", "Red", "White"};
            String color = colors[random.nextInt(colors.length)];

            RootCrop rootVegetable = new RootCrop.Builder()
                    .type(type)
                    .weight(weight)
                    .color(color)
                    .build();

            list.add(rootVegetable);
        }

        return list;
    }
}
