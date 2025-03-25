package ru.home.strategy.inputRootCrop;

import ru.home.model.RootCrop;
import ru.home.strategy.interfaces.DataInputStrategy;

import java.util.Random;

import static ru.home.model.validator.DataValidator.validateVegetableData;

public class RandomInputRootCrop implements DataInputStrategy<RootCrop> {

    private static final Random random = new Random();
    CustomArrayList<RootCrop> rootCrops = new CustomArrayList<>();

    @Override
    public CustomArrayList<RootCrop> inputData() {
        String[] types = {"Carrot", "Potato", "Beet", "Radish", "Turnip"};
        String[] colors = {"Orange", "Brown", "Red", "Purple", "White"};

        for (int i = 0; i < 3; i++) {
            String type = types[random.nextInt(types.length)];
            int weight = random.nextInt(500) + 100; // Weight between 100 and 599
            String color = colors[random.nextInt(colors.length)];

            if (validateVegetableData(type, weight, color)){
                rootCrops.add(new RootCrop.Builder()
                        .type(type)
                        .weight(weight)
                        .color(color)
                        .build());
            }else{
                rootCrops.add(null);
            }
        }
        return rootCrops;
    }
}
