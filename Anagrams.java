package com.yaxuansheng.leetcode.online;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Anagrams {
	public List<String> anagrams(String[] strs) {
		Map<String, List<String>> anagrams = new HashMap<String, List<String>>();
		List<String> results = new LinkedList<String>();

		for (String str : strs) {
			char[] charArray = str.replaceAll("\\s*", "").toCharArray();
			Arrays.sort(charArray);
			String key = String.copyValueOf(charArray);

			if (anagrams.containsKey(key)) {
				anagrams.get(key).add(str);
			} else {
				List<String> list = new LinkedList<String>();
				list.add(str);
				anagrams.put(key, list);
			}
		}

		for (List<String> list : anagrams.values()) {
			if (list.size() > 1)
				results.addAll(list);
		}

		return results;
	}
}
