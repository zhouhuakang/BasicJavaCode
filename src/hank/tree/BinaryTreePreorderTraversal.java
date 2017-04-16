package hank.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
	public ArrayList<Integer> pre(TreeNode root) {
		ArrayList<Integer> returnList = new ArrayList<Integer>();
		if (null == root) {
			return null;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode n = stack.pop();
			returnList.add(n.val);

			if (n.right != null) {
				stack.push(n.right);
			}
			if (n.left != null) {
				stack.push(n.left);
			}
		}
		return returnList;
	}

	public static void main(String[] args) {
		BinaryTreePreorderTraversal binaryTreePreorderTraversal = new BinaryTreePreorderTraversal();
		BuildTree buildTree = new BuildTree();
		TreeNode treeNode = buildTree.getBinarySortTree();
		ArrayList<Integer> returnList = binaryTreePreorderTraversal
				.pre(treeNode);
		for (Integer a : returnList) {
			System.out.println(a);
		}

	}
}
