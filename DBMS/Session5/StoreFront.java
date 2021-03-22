package com.jdbc;
import java.sql.*;
import java.util.ArrayList;

//Class to implement methods to provide various queries over StoreFront database.
public class StoreFront {
	private static final String URL = "jdbc:mysql://localhost:3306/storefront";
	private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "1234";

	private static final String GET_ORDER_DETAILS_QUERY = "SELECT orders.ID, DATE(orders.OrderTime) AS 'Order Date', "
			+ "SUM(ProductQuantity * ProductPrice) AS 'Order Total' " + "FROM orders "
			+ "JOIN order_detail ON orders.ID = order_detail.OrderID " + "WHERE orders.UserID = ? "
			+ "GROUP BY orders.ID " + "ORDER BY orders.OrderTime;";

	private static final String PATH = "C:/Users/abhishek.tyagi_metac/workspace/DBMS_JDBC/assets/";
	private static final String images[] = { PATH + "flower.jfif", PATH + "animal.jfif", PATH + "tree.jfif" };
	private static final String INSERT_IMAGE_QUERY = "UPDATE image " + "SET ImageBlob =  LOAD_FILE(" + "?) "
			+ "WHERE ID = ?;";

	private static final String DELETE_PRODUCT_QUERY = "DELETE FROM product " + "WHERE product.ID NOT IN "
			+ "(SELECT p.ID FROM " + "(SELECT  p.ID " + "FROM orders " + "JOIN order_detail "
			+ "ON orders.ID = order_detail.OrderID " + "JOIN product p ON p.ID = order_detail.ProductID "
			+ "WHERE orders.OrderTime >= DATE_SUB(NOW(), INTERVAL 1 YEAR)) p);";

	private static final String GET_TOP_CATEGORY_QUERY = "SELECT c1.Title, COUNT(*) "
			+ "FROM category c1 JOIN category c2 " + "WHERE c1.ParentID = c2.ID " + "GROUP BY c1.ParentID "
			+ "HAVING c1.ParentID IN " + "(SELECT category.ID " + "FROM category "
			+ "WHERE category.ID = category.ParentID);";

	
	//This method establishes a connection with the database
	public static Connection getConnection() throws SQLException, SQLTimeoutException, ClassNotFoundException {
		Class.forName(DRIVER_CLASS);
		Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		return connection;
	}

	//This method gets order details from Database
	public static ArrayList<OrderDetails> getOrderDetailsOfUser(String userID) {
		ArrayList<OrderDetails> listOfUserOrderDetails = new ArrayList<OrderDetails>();
		try {
			Connection connection = getConnection();
			OrderDetails orderDetails;
			PreparedStatement preparedStatement = connection.prepareStatement(GET_ORDER_DETAILS_QUERY);
			preparedStatement.setString(1, userID);
			ResultSet resultSetOfUserOrderDetails = preparedStatement.executeQuery();
			while (resultSetOfUserOrderDetails.next()) {
				orderDetails = new OrderDetails(resultSetOfUserOrderDetails.getString(1),
						resultSetOfUserOrderDetails.getDate(2), resultSetOfUserOrderDetails.getDouble(3));
				listOfUserOrderDetails.add(orderDetails);
			}
			preparedStatement.close();
			connection.close();
		}
		catch (Exception e) {
			System.out.println("\n" + e.getMessage());
		}
		return listOfUserOrderDetails;
	}

	//This method puts images into Database.
	public static void insertProductImages() {
		// Added blob column in Database
	    // ALTER TABLE image ADD COLUMN ImageBlob BLOB NULL AFTER ProductID;
		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_IMAGE_QUERY);
			int index = 0;
			while (index < images.length) {
				preparedStatement.setString(1, images[index]);
				preparedStatement.setString(2, String.valueOf(index + 1));
				preparedStatement.addBatch();
				index++;
			}
			preparedStatement.executeBatch();
			preparedStatement.close();
			connection.close();
			System.out.println("\nImages inserted into Database.");
		}
		catch (Exception e) {
			System.out.println("\n" + e.getMessage());
		}
	}

	//This method deletes the inactive products from Database
	public static int deleteInactiveProducts() {
		int numberOfRowsUpdated = 0;
		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT_QUERY);
			numberOfRowsUpdated = preparedStatement.executeUpdate();
			preparedStatement.close();
			connection.close();
		}
		catch (Exception e) {
			System.out.println("\n" + e.getMessage());
		}
		return numberOfRowsUpdated;
	}
 
	//return List of details of Top Categories in category table
	public static ArrayList<TopCategory> getTopCategory() {
		ArrayList<TopCategory> listOfTopCategory = new ArrayList<TopCategory>();

		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(GET_TOP_CATEGORY_QUERY);
			ResultSet resultSetOfTopCategory = preparedStatement.executeQuery();
			TopCategory TopCategory;
			while (resultSetOfTopCategory.next()) {
				TopCategory = new TopCategory(resultSetOfTopCategory.getString(1), resultSetOfTopCategory.getInt(2));
				listOfTopCategory.add(TopCategory);
			}
			preparedStatement.close();
			connection.close();
		} 
		catch (Exception e) {
			System.out.println("\n" + e.getMessage());
		}
		return listOfTopCategory;
	}

	public static void main(String[] args) {
		// Assignment 1 query
		System.out.println("Order Details: ");
		System.out.println(StoreFront.getOrderDetailsOfUser("3"));

		System.out.println("\n--------------------------------------");
		// Assignment 2 query
		StoreFront.insertProductImages();

		System.out.println("\n--------------------------------------");
		// Assignment 3 query
		System.out.println("\nNumber of Products Deleted: " + StoreFront.deleteInactiveProducts());

		System.out.println("\n--------------------------------------");
		// Assignment 4 query 
		System.out.println("Top Parent Categories:\n" + StoreFront.getTopCategory());
	}
}