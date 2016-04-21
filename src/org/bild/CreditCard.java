package org.bild;

public class CreditCard {
	
	/*
	 * Credit Card Validation
	 */
	
	static final int[] prefixes = {4, 5, 6, 37};
	
	/** Return true if the card number is valid */
	public static boolean isValid(long number){
		int sum = sumOfDoubleEvenPlace(number) + sumOfOddPlace(number);
		if(sum % 10 != 0)
			return false;
		if((getSize(number) < 13) && (getSize(number) > 16))
			return false;
		for(int i = 0; i < prefixes.length; i++){
			if(prefixMatched(number, prefixes[i]))
				return true;
		}
		return false;
	}
	
	/** Get the result from Step 2 */
	public static int sumOfDoubleEvenPlace(long number){
		int sum = 0;
		number /= 10;
		while(number > 0){
			sum += getDigit((int)(number % 10 ) * 2);
			number /= 100;
		}
		return sum;
	}
	
	/** Return this number if it is a single digit, otherwise,
	* return the sum of the two digits */
	public static int getDigit(int number){
		int digit;
		if(number < 10){
			return number;
		}else {
			int digit1 = number / 10;
			int digit2 = number % 10;
			digit = digit1 + digit2;
		}
		return digit;
	}
	
	/** Return sum of odd-place digits in number from right to left*/
	public static int sumOfOddPlace(long number){
		int sum = 0;
		while(number > 0){
			sum += number % 10;
			number /= 100;	
		}
		return sum;
	}
	
	/** Return true if the digit d is a prefix for number */
	public static boolean prefixMatched(long number, int d){
		for(int i = 0; i < prefixes.length; i++) {
			if(getPrefix(number, d) == prefixes[i])
				return true;
		}
		return false;
	}
	
	/** Return the number of digits in d */
	public static int getSize(long d){
		int count = 0;
		while(d > 0){
			d /= 10;
			count ++;
		}
		return count;
	}
	
	/** Return the first k number of digits from number. If the
	* number of digits in number is less than k, return number. */
	public static long getPrefix(long number, int k){
		if(getSize(number) < k)
			return number;
		int diff = getSize(number) - getSize(k);
		long prefix =  (long) (number / Math.pow(10, diff));
		return prefix;
	}
}
