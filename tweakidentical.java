public class tweakidentical {
	public static class TreeNode {
  /*
   * Special symbol for null node, used in pre-order reconstruction.
   */
  public static final String NULL_NODE = "#";
  /*
   * A TreeNode contains an integer key, a reference to the
   * root of left subtree and a reference to root of the right subtree.
   */
  public int key;
  public TreeNode left;
  public TreeNode right;

  public TreeNode(int key) {
    this.key = key;
  }

  @Override
  public String toString() {
    return String.valueOf(key);
  }

  /**
   * Construct the binary tree using pre-order traversal sequence.
   * 
   * Note: the null node will be represented as a special value "#".
   * 
   * If null node is ignored in the pre-order traversal sequence,
   * the constructed binary tree would not be UNIQUE.
   * 
   * Example:
   *           2
   *       /       \
   *      1         3
   *    /  \      /   \
   * null  null null null
   * 
   * The pre-order traversal sequence is:
   * {"2", "1", "#", "#", "3", "#", "#"}
   * Using the above sequence we can reconstruct the binary tree.
   * 
   * @param preOrder
   *          the preOrder traversal sequence
   * @return the root of the constructed binary tree
   */
  public static TreeNode reConstruct(String[] preOrder) {
    if (preOrder == null || preOrder.length == 0) {
      return null;
    }
    return reConstruct(preOrder, 0).node;
  }

  /*
   * The real implementation of re-construction from preOrder traverse.
   */
  private static Result reConstruct(String[] preOrder, int left) {
    if (preOrder[left].equals(NULL_NODE)) {
      return new Result(left + 1, null);
    }
    TreeNode root = new TreeNode(Integer.parseInt(preOrder[left]));
    Result leftResult = reConstruct(preOrder, left + 1);
    root.left = leftResult.node;
    Result rightResult = reConstruct(preOrder, leftResult.index);
    root.right = rightResult.node;
    rightResult.node = root;
    return rightResult;
  }

  /*
   * Helper class for storing the intermediate information used in
   * reConstruct(String[] preOrder, int left) method.
   */
  private static class Result {
    int index;
    TreeNode node;

    Result(int index, TreeNode node) {
      this.index = index;
      this.node = node;
    }
  }

  /*
   * pre-order traversal to print the given binary tree.
   * null node will be represented as "#".
   */
  public static String preOrder(TreeNode root) {
    if (root == null) {
      return NULL_NODE;
    }
    StringBuilder preOrder = new StringBuilder();
    preOrder(root, preOrder);
    preOrder.deleteCharAt(preOrder.length() - 1);
    return preOrder.toString();
  }
  
  private static void preOrder(TreeNode root, StringBuilder preOrder) {
    if (root == null) {
      preOrder.append(NULL_NODE).append(" ");
      return;
    }
    preOrder.append(root.key).append(" ");
    preOrder(root.left, preOrder);
    preOrder(root.right, preOrder);
  }
}


public boolean tweakedIdentical(TreeNode root1, TreeNode root2) {
	if (root1 == null && root2 == null) {
		return true;
	} else if (root1 == null || root2 == null) {
		return false;
	} else if (root1.key != root2.key) {
    return false;
  } 
  else {
		return isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right) || isIdentical(root1.right, root2.left) && isIdentical(root1.left, root2.right);

	}



}

public boolean isIdentical(TreeNode root1, TreeNode root2) {
	if (root1 == null && root2 == null) {
		return true;
	} else if (root1 == null || root2 == null) {
		return false;
	} else {
		return root1.key == root2.key && isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);

	}
}

public static void main(String[] args) {
	tweakidentical dark = new tweakidentical();
	TreeNode root1 = null;
	TreeNode root2 = null;
	TreeNode root3 = null;
	root1 = TreeNode.reConstruct(new String[] {"5", "3", "1", "#", "#", "4", "#", "#", "8", "#", "#"});
	root3 = TreeNode.reConstruct(new String[] {"5", "3", "2", "#", "#", "4", "#", "#", "8", "#", "#"});
	root2 = TreeNode.reConstruct(new String[] {"5", "8", "#", "#", "3", "1", "#", "#", "4", "#", "#"});
	boolean result = dark.tweakedIdentical(root1, root3);
	System.out.println(result);

}


}