package main.java.ru.home.utill.strategy.inputrootvegetable;

import main.java.ru.home.utill.CustomArrayList;
import main.java.ru.home.utill.model.RootVegetable;
import main.java.ru.home.utill.strategy.interfaces.DataInputStrategy;

import java.util.Random;

public class RandomInputRootVegetable implements DataInputStrategy<RootVegetable> {
    private Random random;

    public RandomInputRootVegetable() {
        this.random = new Random();
    }

    @Override
    public CustomArrayList<RootVegetable> inputData() {
        CustomArrayList<RootVegetable> list = new CustomArrayList<>();

        // Генерация случайного количества корнеплодов (например, от 1 до 10)
        int count = random.nextInt(10) + 1;

        for (int i = 0; i < count; i++) {
            // Генерация случайного типа корнеплода (например, из предопределенного списка)
            String[] types = {"Carrot", "Potato", "Beet", "Radish", "Turnip"};
            String type = types[random.nextInt(types.length)];

            // Генерация случайного веса (например, от 50 до 500 грамм)
            int weight = random.nextInt(451) + 50;

            // Генерация случайного цвета (например, из предопределенного списка)
            String[] colors = {"Orange", "Brown", "Purple", "Red", "White"};
            String color = colors[random.nextInt(colors.length)];

            // Создание объекта RootVegetable с использованием Builder
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