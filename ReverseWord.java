package com.yaxuansheng.leetcode.online;

public class ReverseWord {

	public static String reverseWords(String s) {
		StringBuilder reversed = new StringBuilder();
		// loop s from backward to build reverse string
		int j = s.length();
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == ' ') {
				j = i; // j will be pointed to the location after the last
						// Character of the word
			}
			// find proper starting location of the word
			if (i == 0 || s.charAt(i - 1) == ' ') {
				if (reversed.length() > 0 && i != j) {
					reversed.append(" ");
				}
				reversed.append(s.substring(i, j));
			}
		}

		return reversed.toString();
	}

	public static void main(String[] args) {
		String s = " 1";
		System.out.print(reverseWords(s));

	}

}
