package com.jdbc;

//Class to represent the structure of Top Category Object.
public class TopCategory {
	private String categoryTitle;
	private Integer numberOfProducts;

	public TopCategory(String categoryTitle, Integer numberOfProducts) {
		super();
		this.categoryTitle = categoryTitle;
		this.numberOfProducts = numberOfProducts;
	}

	@Override
	public String toString() {
		return "\n  { Category Title: " + categoryTitle + "," + "\n    No. of Products: " + numberOfProducts + " }\n";
	}
}