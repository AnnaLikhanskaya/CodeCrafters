package ru.home.util;

import ru.home.model.RootCrop;

public class RootCropValidator {
    public static boolean validate(RootCrop rootCrop) {
        return rootCrop.getWeight() > 0 && rootCrop.getType() != null && !rootCrop.getType()
                .isEmpty() && rootCrop.getColor() != null && !rootCrop.getColor().isEmpty();
    }
}