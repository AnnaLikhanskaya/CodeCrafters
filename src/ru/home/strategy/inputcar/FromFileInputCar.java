package ru.home.strategy.inputcar;

import ru.home.model.Car;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FromFileInputCar {

    public List<String> readDataFromFile() throws IOException{

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input path file");
        /* просим пользователя ввести путь к файлу
        * структура файла: в каждой новой строке содержится информация о создаваемом объекте через ", "
        * название модели, мощность, год */
        Path path = Path.of(scanner.nextLine());

        try {
            /*читаем все строки из файла в лист*/
            return Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Car> carBuildFromFile() throws IOException {
        /*создаем список объектов*/
        List<String> list = this.readDataFromFile();
        List<Car> listCar = new ArrayList<>();

        for (String car: list) {
            List list1 = List.of(car.split(", "));
            String model = (String) list1.get(0);
            Integer power = Integer.valueOf((String) list1.get(1));
            Integer year = Integer.valueOf((String) list1.get(2));
            listCar.add(new Car.Builder().power(power).model(model).year(year).build());
        }
        return listCar;
    }
}
