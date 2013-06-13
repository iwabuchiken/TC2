package tc2.B5;

import static org.junit.Assert.*;

import javax.swing.JButton;
import javax.swing.JPanel;

import junit.framework.TestCase;

import org.junit.Test;

public class TC2_B5_v_1_0Test extends TestCase {

	@Test
	public void testTC2_B5_v_1_0() {
//		fail("まだ実装されていません");
		
		TC2_B5_v_1_0 obj = new TC2_B5_v_1_0();
		
		Object o = obj.getBtnGetTime();
		
//		assertTrue("Not an instance of JButton", o instanceof JButton);
		assertTrue("Not an instance of JButton", o instanceof JPanel);
		
		//debug =========================
		System.out.println("["
				+ (new Throwable()).getStackTrace()[0].getFileName() + ":"
				+ (new Throwable()).getStackTrace()[0].getLineNumber() + "] "
				+ "Is an instance of JButton");
		////////////////////////////debug
		
//		System.out.println("Is an instance of JButton");
		
		
	}

	@Test
	public void testMain() {
		fail("まだ実装されていません");
	}

}

