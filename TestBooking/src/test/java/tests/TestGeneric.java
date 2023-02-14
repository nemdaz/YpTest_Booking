package tests;

import org.junit.Test;

import utils.UtilDate;

public class TestGeneric {

	@Test
	public void testDateFormater() {
		String od1 = UtilDate.changeFormat("14/02/2023", "dd/MM/yyyy", "dd MMMM yyyy");
		System.out.println(od1);
		String od2 = UtilDate.changeFormat("28/02/2023", "dd/MM/yyyy", "dd MMMM yyyy");
		System.out.println(od2);
	}
}
