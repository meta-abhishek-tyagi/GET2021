package Assignment4;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class ArrOperationTest {
	
    @Rule
    public ExpectedException exception = ExpectedException.none();
	
	// Return the size of the largest mirror section found in the input array.
	@Test 
	public void MirrorEmptyArrayTest() throws ArrayIndexOutOfBoundsException{
		exception.expect(ArrayIndexOutOfBoundsException.class);
		exception.expectMessage("Array is empty");
		int arr[] = {};
		ArrOperation.largestMirror(arr);
	}
	
	@Test
	public void MirrorTest() {
		int arr[] = {1, 2, 3, 8, 9, 3, 2, 1};
		int expected = 3;
		int actual = ArrOperation.largestMirror(arr);
		assertEquals(expected, actual);
	}
	
	
	// Return the number of clumps in the input array.
	@Test
	public void clumpsEmptyArrayTest() {
		exception.expect(ArrayIndexOutOfBoundsException.class);
                exception.expectMessage("Array is empty");
		int arr[] = {};
		int actual = ArrOperation.clumps(arr);
		int expected = 0;
		assertEquals(expected, actual);
	}

	@Test
	public void clumpsTest() {
		int arr[] = {1,2,2,3,4,4};
		int actual = ArrOperation.clumps(arr);
		int expected = 2;
		assertEquals(expected, actual);
	}
	
	
	
	//Solve fixXY problem
	@Test
	public void fixXYTest1() {
		int arr[] = {5, 4, 9, 4, 9, 5};
		int expected[] = {9, 4, 5, 4, 5, 9};
		int x = 4;
		int y = 5;
		int actual[] = ArrOperation.fixXY(arr, x, y);
		assertArrayEquals(expected, actual);
	}
	
	
	@Test
	public void fixXYEmptyArrayTest() {
		exception.expect(ArrayIndexOutOfBoundsException.class);
                exception.expectMessage("Array is empty");
		int arr[] = {};
		int x = 4;
		int y = 5;
		ArrOperation.fixXY(arr, x, y);
	}
	
	@Test
	public void fixXY_x_AtLastIndex(){
		exception.expect(IllegalStateException.class);
                exception.expectMessage("X is the at the last Index");
		int arr[] = {3,2,4,7,5,3,4,5,5,4};
		int x = 4;
		int y = 5;
		ArrOperation.fixXY(arr, x, y);
	}
	
	@Test 
	public void fixXY_TwoAdjacentX(){
		exception.expect(IllegalStateException.class);
		exception.expectMessage("Two Adjacent X values are there");
		int arr[] = {2, 4, 4, 5, 1};
		int x = 4;
		int y = 5;
		ArrOperation.fixXY(arr, x, y);
	}
	
	
	
	// SplitArray
	@Test
	public void SplitArrayTest() {
		int arr[] = {1, 1, 1, 2, 1};
		int expected = ArrOperation.splitArray(arr);
		int actual = 3;
		assertEquals(expected, actual);
	}
	
	@Test
	public void SplitArrayEmptyArrayTest() {
		int arr[] = {};
		exception.expect(ArrayIndexOutOfBoundsException.class);
		exception.expectMessage("Array is empty");
		ArrOperation.splitArray(arr);
	}
}
