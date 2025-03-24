package ru.home.model.validator;

public class DataValidator {
    public static boolean validateCarData(int power, String model, int year) {
        return power > 0 && model != null && !model.isEmpty() && year > 1900;
    }

    public static boolean validateBookData(String author, String title, int pages) {
        return author != null && !author.isEmpty() && title != null && !title.isEmpty() && pages > 0;
    }


    public static boolean validateVegetableData(String type, double weight, String color) {
        return type != null && !type.isEmpty() && weight > 0 && color != null && !color.isEmpty();
    }
}
