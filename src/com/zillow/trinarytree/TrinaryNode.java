/**This class represents a node of a trinary tree.
 * It holds the left, right and the middle node objects
 */
package com.zillow.trinarytree;

/**Class : TrinaryNode
 * @author Krithiga Sundar Raj
 */
public class TrinaryNode {
	int key;
	TrinaryNode left;
	TrinaryNode middle;
	TrinaryNode right;

	/* Constructor to initialize the node values and the key */
	public TrinaryNode(int key) {
		this.key = key;
		this.left = this.middle = this.right = null;
	}
}