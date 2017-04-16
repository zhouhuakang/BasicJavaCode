package hank.tree;

public class BuildTree {
	private TreeNode binarySortTreeRoot;

	public TreeNode getBinarySortTree() {
		testBuildBinarySortTree();
		return binarySortTreeRoot;
	}

	/**
	 * 递归构建二叉排序树（也称二叉查找树）
	 * 
	 * @param node
	 * @param val
	 */
	public void buildBinarySortTree(TreeNode node, int val) {
		if (null == binarySortTreeRoot) {
			binarySortTreeRoot = new TreeNode(val);
		} else {
			if (node.val <= val) {
				if (null == node.right) {
					node.right = new TreeNode(val);
				} else {
					buildBinarySortTree(node.right, val);
				}
			} else {
				if (null == node.left) {
					node.left = new TreeNode(val);
				} else {
					buildBinarySortTree(node.left, val);
				}
			}
		}
	}

	public void testBuildBinarySortTree() {
		int[] a = { 2, 4, 12, 45, 21, 6, 111 };
		for (int i = 0; i < a.length; i++) {
			buildBinarySortTree(binarySortTreeRoot, a[i]);
		}
	}
}
