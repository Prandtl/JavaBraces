import org.junit.Test;

import static org.junit.Assert.*;

public class testBrace {

	@Test
	public void simpleTest(){
		boolean res=Program.stringValidator("()");
		assertEquals(true, res);
	}
	
	@Test
	public void differentTest(){
		boolean res=Program.stringValidator("{<[[]]()><>}");
		assertEquals(true, res);
	}
	
	@Test
	public void notClosed(){
		boolean res=Program.stringValidator("{()");
		assertEquals(false, res);
	}
	
	@Test
	public void notOpened(){
		boolean res=Program.stringValidator("()}");
		assertEquals(false, res);
	}
	
	@Test
	public void DifferentBraceTest(){
		boolean res=Program.stringValidator("(]");
		assertEquals(false, res);
	}
}
