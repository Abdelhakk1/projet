package project;

import java.util.List;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.model.InternalWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;

public class Main {

	// Add a product
	public static void addProduct() throws IOException {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Add the product code");
		String code = scanner.nextLine();
		System.out.println("Add the product name");
		String name = scanner.nextLine();
		System.out.println("Add the product description");
		String description = scanner.nextLine();
		System.out.println("Add the product quantity");
		int quantity = scanner.nextInt();
		System.out.println("Add the notification threshold");
		int notificationThreshold = scanner.nextInt();
		System.out.println("Add the product price");
		double price = scanner.nextDouble();

		// categories
		Category paintCategory = new Category("PAINT", "Peinture");

		// Create a product object
		Product product = new Product(code, name, description, quantity, notificationThreshold, price, paintCategory);

		// Load the existing workbook
		FileInputStream inputStream = new FileInputStream("stock.xls");
		Workbook workbook = WorkbookFactory.create(inputStream);

		// Get the Products sheet
		Sheet sheet = workbook.getSheet("sheet");

		// Get the last row number and add 1 to get the new row number
		int newRowNum = sheet.getLastRowNum() + 1;

		// Create a new row
		Row row = sheet.createRow(newRowNum);

		// Create the cells for the new row and set their values
		Cell cellCode = row.createCell(0);
		cellCode.setCellValue(product.getCode());

		Cell cellName = row.createCell(1);
		cellName.setCellValue(product.getName());

		Cell cellDescription = row.createCell(2);
		cellDescription.setCellValue(product.getDescription());

		Cell cellQuantity = row.createCell(3);
		cellQuantity.setCellValue(product.getQuantity());

		Cell cellNotificationThreshold = row.createCell(4);
		cellNotificationThreshold.setCellValue(product.getNotificationThreshold());

		Cell cellPrice = row.createCell(5);
		cellPrice.setCellValue(product.getPrice());

		Cell cellCategory = row.createCell(6);
		cellCategory.setCellValue(product.getCategory().getName());

		// Save the changes to the workbook
		FileOutputStream outputStream = new FileOutputStream("stock.xls");
		workbook.write(outputStream);
		workbook.close();

		System.out.println("Product added to Excel file.");

	}

	// Display products list
	public static void display() throws IOException {
		System.out.println("Entred display fonction");
		FileInputStream inpsr = new FileInputStream("stock.xls");
		Workbook workbook = new HSSFWorkbook(inpsr);
		Sheet sheet = workbook.getSheetAt(0);
		for (Row row : sheet) {
			System.out.println(row.toString());
			for (Cell cell : row) {
				System.out.print(cell + "\t");
			}
			System.out.println();
		}
		workbook.close();
		inpsr.close();
	}

	// Search according to product/categorie/keywords
	public static void search(int type, String value) throws IOException {
		System.out.println("Entred seacrch fonction");
		FileInputStream inpsr = new FileInputStream("stock.xls");
		Workbook workbook = new HSSFWorkbook(inpsr);
		Sheet sheet = workbook.getSheetAt(0);
		if (type==1) {
	            for (Row row : sheet) {
	                Cell cell = row.getCell(1);
	                if (cell != null && cell.getStringCellValue().equals(value)) {
	                	for (Cell cell2 : row) {
	        				System.out.print(cell + "\t");
	        			}
	        			System.out.println();
	                }
	            }
	        } else if (type==2){
	        	for (Row row : sheet) {
	                Cell cell = row.getCell(1);
	                if (cell != null && cell.getStringCellValue().equals(value)) {
	                	for (Cell cell2 : row) {
	        				System.out.print(cell + "\t");
	        			}
	        			System.out.println();
	                }
	            }
	        } else if (type==3) {
	        	for (Row row : sheet) {
	                Cell cell = row.getCell(1);
	                if (cell != null && cell.getStringCellValue().equals(value)) {
	                	for (Cell cell2 : row) {
	        				System.out.print(cell + "\t");
	        			}
	        			System.out.println();
	                }
	            }
	        }
		workbook.close();
		inpsr.close();
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
				// deleteProduct();
				break;
			case "modify":
				// modifyQuantity();
				break;
			case "search":
				System.out.println("Search according to 1: product name \n 2: categorie \n 3: key-word");
				int stype = scanner.nextInt();
				System.out.println("Enter the value you want to search");
				String svalue = scanner.nextLine();
				search(stype, svalue);
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

		// Creer une nouvelle liste de produits
		ProductList productList = new ProductList();

		// Creer une catégorie de peinture
		Category paintCategory = new Category("PAINT", "Peinture");

		// Créer quelques produits de peinture
		Product redPaint = new Product("RP-1", "Peinture rouge", "Peinture rouge de haute qualité", 100, 50, 10.99,
				paintCategory);

		// Ajouter les produits à la liste
		productList.addProduct(redPaint);

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

		}
	}
}
