package domains;

public class Food {
    private String description;
    private String imageUrl;
    private double price;
    private String name;
    private String foodType;

    public Food(String description, String imageUrl, double price, String name, String foodType) {
        this.description = description;
        this.imageUrl = imageUrl;
        this.price = price;
        this.name = name;
        this.foodType = foodType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }
}
