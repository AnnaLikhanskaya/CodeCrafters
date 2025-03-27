package ru.home.strategy.inputcar;

import ru.home.model.Car;
import ru.home.model.validator.DataValidator;
import ru.home.util.CustomArrayList;
import ru.home.strategy.interfaces.DataInputStrategy;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


public class FileInputCar  implements DataInputStrategy<Car> {
    String filePath;

    public FileInputCar() {
        this.filePath = "C:\\CodeCrafters\\car.txt";
    }

    @Override
    public CustomArrayList<Car> inputData() {

        List<String> list = List.of();
        try {
            /*читаем все строки из файла в лист*/
            list = Files.readAllLines(Path.of(this.filePath));
        } catch (IOException e) {
            System.err.println("File not found" + this.filePath);
            e.printStackTrace();
        }
        CustomArrayList<Car> carCustomArrayList = new CustomArrayList<>();

        for (String car : list) {
            /*валидация и создание листа объектов*/
            List list1 = List.of(car.split(", "));
            String model = (String) list1.get(0);
            Integer power = Integer.valueOf((String) list1.get(1));
            Integer year = Integer.valueOf((String) list1.get(2));
            if (DataValidator.validateCarData(power, model, year)){
                /*если ошибка валидации - пропускаем строку и не создаем объект*/
                carCustomArrayList.add(new Car.Builder().power(power).model(model).year(year).build());
            }
        }
        return carCustomArrayList;
    }
}
