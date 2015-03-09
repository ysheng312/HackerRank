package com.yaxuansheng.leetcode.online;

public class RomanInteger {

	private static final int[] values = {
			1000, 900, 500, 400,
			100, 90, 50, 40,
			10, 9, 5, 4,
			1
	};
	
	private static final String[] symbols = {
		"M", "CM", "D", "CD",
		"C", "XC", "L", "XL",
		"X", "IX", "V", "IV",
		"I"
	};
	
	public static String intToRoman(int num)
	{
		StringBuilder roman = new StringBuilder();
		
		int i = 0;
		while(num > 0)
		{
			int k = num/values[i];
			for (int j = 0; j < k; j++)
			{
				roman.append(symbols[i]);
				num -= values[i];
			}
			i++;
		}
		
		return roman.toString();
	}
	
	public static int romanToInt(String roman)
	{
		int num = 0;
		
		int i = 0;
		int j = 0;
		while (j < roman.length())
		{
			
			if (roman.substring(j, Math.min(j + symbols[i].length(), roman.length())).equals(symbols[i]))
			{
				num += values[i];
				j += symbols[i].length();
			}
			else
				i++;
		}
		
		return num;
	}
	
	public static void main(String[] args)
	{
		int num = 3999;
		System.out.println(intToRoman(num));
		
		String roman = "MCMXCVI";
		System.out.println(romanToInt(roman));
	}
}
