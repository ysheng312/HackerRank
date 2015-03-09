package com.yaxuansheng.leetcode.online;

public class RotateArray {

	public static void reverseArray(int[] A, int left, int right) {
		if (left < 0 || right < 0 || left > right || right > A.length)
			return;

		int l = left;
		int r = right;
		while (l < r) {
			int temp = A[l];
			A[l] = A[r];
			A[r] = temp;
			r--;
			l++;
		}
	}

	public static void rotate(int[] nums, int k) {
		if (k < 0)
			return;

		int modK = k % nums.length;

		if (modK == 0)
			return;

		int n = nums.length;
		reverseArray(nums, 0, n - 1);
		reverseArray(nums, 0, modK - 1);
		reverseArray(nums, modK, n - 1);
	}

	public static void main(String[] args) {
		int nums[] = { 1, 2, 3, 4, 5, 6, 7 };
		int n = 7;
		int k = 3;

		rotate(nums, k);

		for (int num : nums) {
			System.out.print(num + " ");
		}
	}

}
