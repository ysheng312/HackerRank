package com.yaxuansheng.leetcode.online;

public class StrStr {

	public static int strStr(String haystack, String needle) {
		for (int i = 0;; i++) {
			for (int j = 0;; j++) {
				if (j == needle.length())
					return i;
				if (i + j == haystack.length())
					return -1;
				if (needle.charAt(j) != haystack.charAt(i + j))
					break;
			}
		}
	}

	public static void main(String[] args) {
		String h = "aaa";
		String n = "a";

		System.out.println(strStr(h, n));
	}

}
