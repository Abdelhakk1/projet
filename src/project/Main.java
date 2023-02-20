package project;

import java.util.List;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;

public class Main {

	// Add a product
	public static void addProduct() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("add the product code");
		String code = scanner.nextLine();
		System.out.println("Add the product name");
		String name = scanner.nextLine();
		System.out.println("Add the product discription");
		String description = scanner.nextLine();
		int quantity = scanner.nextInt();
		int notificationThreshold = scanner.nextInt();
		double price = scanner.nextDouble();
		System.out.println("Type the dimensions of the product");
		double length = scanner.nextDouble();
		double width = scanner.nextDouble();
		double height = scanner.nextDouble();
		Dimensions dimensions = new Dimensions(length, width, height);
		// categories
		Category paintCategory = new Category("PAINT", "Peinture");

		// Add the product
		Product product = new Product(code, name, description, quantity, notificationThreshold, price, dimensions,
				paintCategory);
	}

	// Display products list
	public static void display() throws IOException {
		FileInputStream inpsr = new FileInputStream("stock.xls");
		Workbook workbook = new HSSFWorkbook(inpsr);
		Sheet sheet = workbook.getSheetAt(0);
		for (Row row : sheet) {
			for (Cell cell : row) {
				System.out.print(cell + "\t");
			}
			System.out.println();
		}
		workbook.close();
		inpsr.close();
	}

	// Search according to product/categorie/keywords
	public void search(String type, String value) {

	}

	// Delete a product
	public void deleteProduct(String product) {

	}

	// Modify quantity of a product
	public void modifyQt(Product product, int newQt) {

	}

	// Modify a categorie product
	public void modify(Product product, String infoType, String infoModified) {

	}

	public static void main(String[] args) throws IOException {

		System.out.println("type 'add' to add a product");
		System.out.println("type 'delete' to delete a product");
		System.out.println("Tap 'display' to display the list of products");
		System.out.println("Tap 'search' to search products");
		System.out.println("Tap 'modify' to modify the stock");

		Scanner scanner = new Scanner(System.in);
		String command;

		do {
			System.out.print("Enter a command: ");
			command = scanner.nextLine();

			switch (command) {
			case "add":
				addProduct();
				break;
			case "delete":
				//deleteProduct();
				break;
			case "modify":
				//modifyQuantity();
				break;
			case "search":
				//searchProduct();
				break;
			case "display":
				display();
				break;
			case "exit":
				break;
			default:
				System.out.println("Invalid command");
				break;
			}
		} while (!command.equals("exit"));

		// Créer une nouvelle liste de produits
		ProductList productList = new ProductList();

		// Créer une catégorie de peinture
		Category paintCategory = new Category("PAINT", "Peinture");

		// Créer quelques produits de peinture
		Product redPaint = new Product("RP-1", "Peinture rouge", "Peinture rouge de haute qualité", 100, 50, 10.99,
				new Dimensions(10, 20, 30), paintCategory);
		Product bluePaint = new Product("BP-2", "Peinture bleue", "Peinture bleue de haute qualité", 80, 40, 12.99,
				new Dimensions(20, 40, 60), paintCategory);
		Product greenPaint = new Product("GP-3", "Peinture verte", "Peinture verte de haute qualité", 60, 30, 14.99,
				new Dimensions(30, 60, 90), paintCategory);

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

			// Notification

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
				Notification notification = new Notification(redPaint,
						redPaint.getNotificationThreshold() - redPaint.getQuantity());
				System.out.println("Notification de rupture de stock créée pour le produit '"
						+ notification.getProduct().getName() + "' (quantité requise: " + notification.getQuantity()
						+ ")");
			}

			// Modifier la quantité en stock d'un produit
			bluePaint.addQuantity(20);
			System.out.println("Nouvelle quantité en stock pour le produit '" + bluePaint.getName() + "': "
					+ bluePaint.getQuantity());
		}
	}
}
