package ru.ggfteam.gottagofoodbackend.entities;

public class Product {
    private double productID;
    private String name;
    private String size;
    private double energy_value;
    private double proteins;
    private double fats;
    private double carbohydrates;

    public double getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getEnergy_value() {
        return energy_value;
    }

    public void setEnergy_value(Double energy_value) {
        this.energy_value = energy_value;
    }

    public double getProteins() {
        return proteins;
    }

    public void setProteins(Double proteins) {
        this.proteins = proteins;
    }

    public double getFats() {
        return fats;
    }

    public void setFats(Double fats) {
        this.fats = fats;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(Double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }
}
