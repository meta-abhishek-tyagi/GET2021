package Assignment5;

import static org.junit.Assert.*;
import org.junit.Test;

public class SearchTest {

	//Test cases for Linear Search
	@Test
	public void linearSearchPositiveTestCase() {
		int arr[] = {1, 3, 5, 7, 9};
		int itemToSearch = 7;
		int expected = 3;
		int actual = Search.linearSearch(arr, 0, arr.length-1, itemToSearch);
		assertEquals(expected, actual);
	}
	
	@Test
	public void linearSearchNegativeTestCase(){
		int arr[] = {1, 3, 5, 7, 9};
		int itemToSearch = 11;
		int expected = -1;
		int actual = Search.linearSearch(arr, 0, arr.length-1, itemToSearch);
		assertEquals(expected, actual);
	}
	
	//Test cases for Binary Search
	@Test
	public void binarySearchPositiveTestCase() {
		int arr[] = {2, 4, 6, 8, 10};
		int itemToSearch = 6;
		int expected = 2;
		int actual = Search.binarySearch(arr, 0, arr.length-1, itemToSearch);
		assertEquals(expected, actual);
	}

	@Test
	public void binarySearchNegativeTestCase(){
		int arr[] = {2, 4, 6, 8, 10};
		int itemToSearch = 5;
		int expected = -1;
		int actual = Search.binarySearch(arr, 0, arr.length-1, itemToSearch);
		assertEquals(expected, actual);
	}
	
}	
