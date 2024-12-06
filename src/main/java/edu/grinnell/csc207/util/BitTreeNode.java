package edu.grinnell.csc207.util;

/**
 * @author Kevin Tang
 * Bit tree node.
 */
public class BitTreeNode {
  /**
   * value of node.
   */
  String value;
  /**
   * left child.
   */
  BitTreeNode leftNode;
  /**
   * right child.
   */
  BitTreeNode rightNode;

  /**
   * Constructor.
   * @param value value of current node
   */
  public BitTreeNode(String value) {
    this.value = value;
    this.leftNode = null;
    this.rightNode = null;
  } // BitTreeNode

  /**
   * get value of current node.
   * @return value
   */
  public String getValue() {
    return this.value;
  } // getValue

  /**
   * get left child of current node.
   * @return left child
   */
  public BitTreeNode getLeftNode() {
    return this.leftNode;
  } // getLeftNode

  /**
   * get right child of current node.
   * @return right child
   */
  public BitTreeNode getRightNode() {
    return this.rightNode;
  } // getRightNode

  /**
   * set value of current node.
   * @param value value
   */
  public void setValue(String value) {
    this.value = value;
  } // setValue

  /**
   * set value of left child node.
   * @param leftNode left child node
   */
  public void setLeftNode(BitTreeNode leftNode) {
    this.leftNode = leftNode;
  } // setLeftNode

  /**
   * set value of right child node.
   * @param rightNode right child node
   */
  public void setRightNode(BitTreeNode rightNode) {
    this.rightNode = rightNode;
  } // setRightNode
} // BitTreeNode
