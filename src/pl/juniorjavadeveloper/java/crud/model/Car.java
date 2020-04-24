package pl.juniorjavadeveloper.java.crud.model;

import java.math.BigDecimal;

public class Car {
    private int id;

    private Integer year;
    private String model;
    private String manufacturer;
    private BigDecimal price;

    public Car() {
    }

    public Car(int year, String model, String manufacturer, BigDecimal price) {
        this.year = year;
        this.model = model;
        this.manufacturer = manufacturer;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", year=" + year +
                ", model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                '}';
    }
}
