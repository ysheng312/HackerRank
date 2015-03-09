import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class HackerRank_SwapNodes {
	static class TreeNode {
		int value;
		TreeNode left;
		TreeNode right;

		public TreeNode(int v) {
			value = v;
		}
	}

	private static void swapTreeAtLevel(TreeNode p, int swapLevel) {
		if (p == null)
			return;
		if (swapLevel == 1) {
			TreeNode temp = p.left;
			p.left = p.right;
			p.right = temp;
		} else {
			swapTreeAtLevel(p.left, swapLevel - 1);
			swapTreeAtLevel(p.right, swapLevel - 1);
		}
	}

	public static int maxHeightPostOrder(TreeNode root) {
		if (root == null)
			return 0;
		Stack<TreeNode> s = new Stack<TreeNode>();
		s.push(root);
		int maxDepth = 0;
		TreeNode prev = null;

		// go down the tree.
		// check if current node is leaf, if so, process it and pop stack,
		// otherwise, keep going down
		while (s.empty() != true) {
			TreeNode curr = s.peek();
			if (prev == null || prev.left == curr || prev.right == curr) {
				// prev == null is the situation for the root node
				if (curr.left != null)
					s.push(curr.left);
				else if (curr.right != null)
					s.push(curr.right);
				else
					s.pop();

			}
			// go up the tree from left node
			// need to check if there is a right child
			// if yes, push it to stack
			// otherwise, process parent and pop stack
			else if (curr.left == prev) {
				if (curr.right != null)
					s.push(curr.right);
				else
					s.pop();
			}
			// go up the tree from right node
			// after coming back from right node, process parent node and pop
			// stack.
			else if (curr.right == prev) {
				s.pop();
			}

			prev = curr;
			if (maxDepth < s.size())
				maxDepth = s.size();
		}
		return maxDepth;
	}

	private static void inorder(TreeNode p) {
		if (p == null)
			return;

		inorder(p.left);
		System.out.print(p.value + " ");
		inorder(p.right);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int numOfNodes = scanner.nextInt();
		List<TreeNode> nodePool = new ArrayList<TreeNode>();
		// First Create those nodes
		for (int i = 1; i <= numOfNodes; i++) {
			TreeNode node = new TreeNode(i);
			nodePool.add(node);
		}

		// Construct the Tree
		for (int i = 1; i <= numOfNodes; i++) {
			int l = scanner.nextInt();
			int r = scanner.nextInt();
			TreeNode curr = nodePool.get(i - 1);
			TreeNode left = null;
			TreeNode right = null;
			if (l > 0)
				left = nodePool.get(l - 1);
			if (r > 0)
				right = nodePool.get(r - 1);
			curr.left = left;
			curr.right = right;
		}

		TreeNode root = nodePool.get(0);
		int maxHeight = maxHeightPostOrder(root);
		int numOfSwaps = scanner.nextInt();
		for (int i = 0; i < numOfSwaps; i++) {
			int K = scanner.nextInt();

			for (int j = 1; j < Integer.MAX_VALUE; j++) {
				int swapLevel = j * K;

				if (swapLevel > maxHeight)
					break;

				swapTreeAtLevel(root, swapLevel);
			}
			inorder(root);
			System.out.println();
		}

		scanner.close();
	}
}