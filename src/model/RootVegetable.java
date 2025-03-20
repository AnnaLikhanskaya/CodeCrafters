import java.util.Comparator;
import java.util.Objects;

public class RootVegetable {

    private String type;
    private String color;
    private int weight;  // Вес (например, в граммах)

    // Приватный конструктор для использования только билдером
    private RootVegetable(RootVegetableBuilder builder) {
        this.type = builder.type;
        this.color = builder.color;
        this.weight = builder.weight;
    }

    public String getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "RootVegetable{" +
                "type='" + type + '\'' +
                ", color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RootVegetable rootVeg = (RootVegetable) o;
        return weight == rootVeg.weight && Objects.equals(type, rootVeg.type) && Objects.equals(color, rootVeg.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, color, weight);
    }

    // Builder
    public static class RootVegetableBuilder {
        private String type;
        private String color;
        private int weight;

        public RootVegetableBuilder type(String type) {
            this.type = type;
            return this;
        }

        public RootVegetableBuilder color(String color) {
            this.color = color;
            return this;
        }

        public RootVegetableBuilder weight(int weight) {
            this.weight = weight;
            return this;
        }

        public RootVegetable build() {
            if (type == null || type.trim().isEmpty()) {
                throw new IllegalArgumentException("Type must be specified.");
            }
            return new RootVegetable(this);
        }
    }

    // Comparator (по типу)
    public static class TypeComparator implements Comparator<RootVegetable> {
        @Override
        public int compare(RootVegetable crop1, RootVegetable crop2) {
            return String.compare(crop1.getType(), crop2.getType());
        }
    }

    // Comparator (по цвету)
    public static class ColorComparator implements Comparator<RootVegetable> {
        @Override
        public int compare(RootVegetable crop1, RootVegetable crop2) {
            return String.compare(crop1.getColor(), crop2.getColor());
        }
    }

    // Comparator (по весу)
    public static class WeightComparator implements Comparator<RootVegetable> {
        @Override
        public int compare(RootVegetable crop1, RootVegetable crop2) {
            return Integer.compare(crop1.getWeight(), crop2.getWeight());
        }
    }
}