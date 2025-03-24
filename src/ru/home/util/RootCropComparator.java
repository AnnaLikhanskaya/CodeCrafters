package ru.home.util;

import ru.home.model.RootCrop;
import java.util.Comparator;

public class RootCropComparator implements Comparator<RootCrop> {
    @Override
    public int compare(RootCrop rc1, RootCrop rc2) {
        return rc1.getType().compareTo(rc2.getType());
    }
}
