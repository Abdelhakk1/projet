package project;


import java.util.List;


public class Main {
    public static void main(String[] args) {
        // Créer une nouvelle liste de produits
        ProductList productList = new ProductList();

        // Créer une catégorie de peinture
        Category paintCategory = new Category("PAINT", "Peinture");

        // Créer quelques produits de peinture
        Product redPaint = new Product("RP-1", "Peinture rouge", "Peinture rouge de haute qualité", 100, 50, 10.99, new Dimensions(10, 20, 30), paintCategory);
        Product bluePaint = new Product("BP-2", "Peinture bleue", "Peinture bleue de haute qualité", 80, 40, 12.99, new Dimensions(20, 40, 60), paintCategory);
        Product greenPaint = new Product("GP-3", "Peinture verte", "Peinture verte de haute qualité", 60, 30, 14.99, new Dimensions(30, 60, 90), paintCategory);

        // Ajouter les produits à la liste
        productList.addProduct(redPaint);
        productList.addProduct(bluePaint);
        productList.addProduct(greenPaint);

        // Créer un objet d'authentification
        Authentication authentication = new Authentication();

        // Ajouter un utilisateur
        authentication.addUser("ammi", "bachir");

        // Vérifier les informations d'identification de l'utilisateur
        boolean isAuthenticated = authentication.checkCredentials("ammi", "bachir");
        if (isAuthenticated) {
            System.out.println("Authentification réussie");

            // Afficher la liste de produits
            for (Product product : productList.getProducts()) {
                System.out.println(product.getName() + " (" + product.getQuantity() + " en stock)");
            }

            // Effectuer une recherche de produits par mot-clé
            List<Product> searchResults = productList.search("rouge");
            System.out.println("Résultats de la recherche pour 'rouge':");
            for (Product product : searchResults) {
                System.out.println(product.getName());
            }

            // Effectuer un filtrage de produits par catégorie
            List<Product> filteredResults = productList.filterByCategory(paintCategory);
            System.out.println("Produits filtrés par catégorie 'Peinture':");
            for (Product product : filteredResults) {
                System.out.println(product.getName());
            }

            // Vérifier si un produit est en dessous du seuil de notification
            boolean isBelowThreshold = redPaint.isBelowNotificationThreshold();
            if (isBelowThreshold) {
                // Créer une notification de rupture de stock
                Notification notification = new Notification(redPaint, redPaint.getNotificationThreshold() - redPaint.getQuantity());
                System.out.println("Notification de rupture de stock créée pour le produit '" + notification.getProduct().getName() + "' (quantité requise: " + notification.getQuantity() + ")");
            }

            // Modifier la quantité en stock d'un produit
            bluePaint.addQuantity(20);
            System.out.println("Nouvelle quantité en stock pour le produit '" + bluePaint.getName() + "': " + bluePaint.getQuantity());
        }
    }
}

