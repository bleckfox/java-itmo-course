package homeWorks.homeWork14.task1;

import java.util.Comparator;
import java.util.Objects;

public class Fruit {
    private FruitType type;
    private double price;

    private int count;

    public Fruit() { }

    public Fruit(FruitType type, double price, int count){
        this.type = type;
        setCount(count);
        setPrice(price);
    }

    public FruitType getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Fruit fruit = (Fruit) obj;
        return price == fruit.getPrice() && type == fruit.getType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, price);
    }

    @Override
    public String toString() {
        return "\n" +
                "Fruit { " +
                "type = " + type + ", " +
                "price = " + price + ", " +
                "count = " + count + " }";
    }

    public static class NameComparator implements Comparator<Fruit>{
        @Override
        public int compare(Fruit o1, Fruit o2) {
            return o2.getType().getName().compareTo(o1.getType().getName());
        }
    }

    public static class PriceComparator implements Comparator<Fruit>{
        @Override
        public int compare(Fruit o1, Fruit o2) {
            return (int) (o2.getPrice() - o1.getPrice());
        }
    }
}
