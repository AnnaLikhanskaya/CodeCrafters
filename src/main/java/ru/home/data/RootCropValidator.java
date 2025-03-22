package main.java.ru.home.data;

public class RootCropValidator implements DataValidator<RootCrop> {
    @Override
    public boolean isValid(RootCrop rootCrop) {
        return rootCrop.getType() != null && !rootCrop.getType().isEmpty() &&
                rootCrop.getWeight() > 0 &&
                rootCrop.getColor() != null && !rootCrop.getColor().isEmpty();
    }
}