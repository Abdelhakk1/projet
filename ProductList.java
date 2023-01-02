package project;

import java.util.ArrayList;
import java.util.List;

public class ProductList {
    private List<Product> products;

    public ProductList() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Product> search(String keyword) {
        List<Product> searchResults = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().contains(keyword) || product.getDescription().contains(keyword)) {
                searchResults.add(product);
            }
        }
        return searchResults;
    }

    public List<Product> filterByCategory(Category category) {
        List<Product> filteredResults = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory().equals(category)) {
                filteredResults.add(product);
            }
        }
        return filteredResults;
    }
}
