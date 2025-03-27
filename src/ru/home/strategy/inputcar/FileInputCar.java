package ru.home.strategy.inputcar;

import ru.home.model.Car;
import ru.home.model.validator.DataValidator;
import ru.home.strategy.interfaces.DataInputStrategy;
import ru.home.util.CustomArrayList;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


public class FileInputCar implements DataInputStrategy<Car> {
    private String filePath;

    public FileInputCar() {
        this.filePath = "C:\\Users\\andre\\IdeaProjects\\CodeCrafters\\src\\car.txt";
    }

    @Override
    public CustomArrayList<Car> inputData() {
        CustomArrayList<Car> carCustomArrayList = new CustomArrayList<>();

        try {
            // Чтение всех строк из файла
            List<String> lines = Files.readAllLines(Path.of(this.filePath));

            // Проверка, что количество строк кратно 3
            if (lines.size() % 3 != 0) {
                throw new IllegalArgumentException("Некорректный формат файла. Количество строк должно быть кратно 3.");
            }

            for (int i = 0; i < lines.size(); i += 3) {
                int power = Integer.parseInt(lines.get(i).trim());
                String model = lines.get(i + 1).trim();
                int year = Integer.parseInt(lines.get(i + 2).trim());

                // Валидация данных
                if (DataValidator.validateCarData(power, model, year)) {

                    carCustomArrayList.add(new Car.Builder().power(power).model(model).year(year).build());
                } else {
                    System.out.println("Некорректные данные в строках: " + lines.get(i) + ", " + lines.get(i + 1) + ", " + lines.get(i + 2));
                }
            }
        } catch (IOException e) {
            System.err.println("Файл не найден: " + this.filePath);
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println("Ошибка в преобразовании числа: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        return carCustomArrayList;
    }
}
