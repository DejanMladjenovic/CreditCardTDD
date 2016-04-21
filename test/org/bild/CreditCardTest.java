package org.bild;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CreditCardTest {
	
	private CreditCard card;

	@Before
	public void setUp() throws Exception {
		card = new CreditCard();
	}

	@After
	public void tearDown() throws Exception {
		card = null;
	}

	@Test
	public void testGetDigit() {
		int digit1 = card.getDigit(12);
		int digit2 = card.getDigit(6);
		assertEquals(3, digit1);
		assertEquals(6, digit2);
	}

	@Test
	public void testSumOfDoubleEvenPlace() {
		int sum = card.sumOfDoubleEvenPlace(4388576018402626L);
		assertEquals(37, sum);
	}
	
	@Test
	public void testSumOfOddPlace() {
		int sum = card.sumOfOddPlace(4388576018402626L);
		assertEquals(38, sum);
	}
	
	@Test
	public void testGetSize(){
		int size = card.getSize(4388576018402626L);
		assertEquals(16, size);
	}
	
	@Test
	public void testGetPrefix(){
		int result = (int) CreditCard.getPrefix(4388576018402626L, 4);
		int result2 = (int) CreditCard.getPrefix(4, 5);
		assertEquals(4, result);
		assertEquals(4, result2);
	}
	
	@Test
	public void testPrefixMatched(){
		boolean result = card.prefixMatched(4388576018402626L, 4);
		assertTrue(result);
	}
	
	@Test
	public void testIsValid(){
		assertTrue(card.isValid(4388576018410707L));
		assertFalse(card.isValid(4388576018402626L));
	}
}
