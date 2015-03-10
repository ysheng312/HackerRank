package com.yaxuansheng.leetcode.online;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */
public class BinaryTreePreorder {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> traverse = new LinkedList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();

		stack.push(root);

		while (stack.isEmpty() != true) {
			TreeNode curr = stack.pop();

			if (curr != null) {
				stack.push(curr.right);
				stack.push(curr.left);
				traverse.add(curr.val);
			}
		}

		return traverse;
	}
}