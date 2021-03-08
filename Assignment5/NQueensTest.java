package Assignment5;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class NQueensTest {
	boolean output=true;
	NQueens obj=new NQueens();
	
	@Test
	public void NQueensTestCase(){
		assertEquals(output, obj.solveNQ());
	}
}
