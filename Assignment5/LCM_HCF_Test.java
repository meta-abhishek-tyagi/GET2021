package Assignment5;

import static org.junit.Assert.*;
import org.junit.Test;

public class LCM_HCF_Test {
	int x=5;
	int y=10;
	int lcm=10;
	int hcf=5;
	
	//Test case for LCM
	@Test
	public void LCM_TestCase(){
		assertEquals(lcm, LCM_HCF.lcm(x, y));
	}
	
	//Test case for HCF
	@Test
	public void HCF_TestCase(){
		assertEquals(hcf, LCM_HCF.hcf(x, y));
	}
}
