/**This class represents the actual trinary tree.
 * It holds the trinary node object and performs the
 * insert and delete operations on the node
 * 
 * Assumptions : The delete functionality assumes that
 * 				 we specify the node and the key for 
 * 				 the node to insert instead of searching
 * 				 the node with the specified key
 */
package com.zillow.trinarytree;

/**Class : TrinaryTree
 * @author Krithiga Sundar Raj 
 */
public class TrinaryTree {

	TrinaryNode root;

	public TrinaryTree() {
		root = null;
	}

	/**This function performs insertion of a node in a trinary tree
	 * @param value
	 * @param node
	 * @return TrinaryNode, the inserted node
	 */
	public TrinaryNode insert(int value, TrinaryNode node){
		if(node == null){
			node = new TrinaryNode(value);
		} else if(value < node.key){
			node.left = insert(value, node.left);
		}else if(value > node.key){
			node.right = insert(value, node.right);
		}else {
			node.middle = insert(value, node.middle);
		}
		return node;
	}

	/**This method performs deletion of a node from a trinary tree
	 * @param value
	 * @param node
	 * @return TrinaryNode, the deleted node
	 */
	public TrinaryNode delete(int value, TrinaryNode node){
		if (node == null) {
			throw new RuntimeException();
		} else if (value < node.key) {
			node.left = delete(value, node.left);
		} else if (value > node.key) {
			node.right = delete(value, node.right);
		} else {
			if (node.middle != null) {
				node.middle = delete(value, node.middle);
			} else if (node.right != null) {
				node.key = findSuccessorNode(node.right).key;
				node.right = delete(findSuccessorNode(node.right).key, node.right);
			} else {
				node = node.left;
			}
		}
		return node;
	}


	/**This function finds a successor node to replace the deleted node
	 * @param node
	 * @return TrinaryNode, the node to be replaced
	 */
	public TrinaryNode findSuccessorNode(TrinaryNode node) {
		if (node != null) {
			while (node.left != null) {
				return findSuccessorNode(node.left);
			}
		}
		return node;
	}
}
