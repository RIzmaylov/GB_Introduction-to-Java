package Homework_06;

public class Laptop {
    int SN;
    String brand;
    String model;
    int RAM;
    int ROM;
    String color;
    String installedOS;

    @Override
    public String toString() {
        return "Brand: " + brand + "\n" + 
               "Model: " + model + "\n" +
               "RAM: " + RAM + "\n" + 
               "ROM: " + ROM + "\n" +
               "Color: " + color.toString() + "\n" +
               "Installed OS: " + installedOS + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Laptop)) return false;
        Laptop laptop = (Laptop) obj;
        return SN == laptop.SN && brand.equals(laptop.brand) && model.equals(laptop.model);
    }

    @Override
    public int hashCode() {
        return 103 * SN + 127 * brand.hashCode() + 37 * model.hashCode();
    }
}
