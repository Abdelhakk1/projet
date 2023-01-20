package project;

import java.util.UUID;

public class Product {
    private UUID id;
    private String code;
    private String name;
    private String description;
    private int quantity;
    private int notificationThreshold;
    private double price;
    private Dimensions dimensions;
    private Category category;

    public Product(String code, String name, String description, int quantity, int notificationThreshold, double price, Dimensions dimensions, Category category) {
        this.id = UUID.randomUUID();
        this.code = code;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.notificationThreshold = notificationThreshold;
        this.price = price;
        this.dimensions = dimensions;
        this.category = category;
    }

    public UUID getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getNotificationThreshold() {
        return notificationThreshold;
    }

    public double getPrice() {
        return price;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public Category getCategory() {
        return category;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setNotificationThreshold(int notificationThreshold) {
        this.notificationThreshold = notificationThreshold;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean isBelowNotificationThreshold() {
        return quantity <= notificationThreshold;
    }

    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }

    public void removeQuantity(int quantity) {
        this.quantity -= quantity;
    }
}
