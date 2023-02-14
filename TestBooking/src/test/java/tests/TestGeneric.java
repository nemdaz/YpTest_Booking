package tests;

import org.junit.Test;

import utils.Utility;

public class TestGeneric {

	@Test
	public void testDateFormater() {
		String od1 = Utility.dateChangeFormat("14/02/2023", "dd/MM/yyyy", "dd MMMM yyyy");
		System.out.println(od1);
		String od2 = Utility.dateChangeFormat("28/02/2023", "dd/MM/yyyy", "dd MMMM yyyy");
		System.out.println(od2);
	}
}
