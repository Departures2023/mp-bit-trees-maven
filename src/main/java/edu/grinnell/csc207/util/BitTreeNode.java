package edu.grinnell.csc207.util;

public class BitTreeNode {
  String value;
  BitTreeNode leftNode;
  BitTreeNode rightNode;

  public BitTreeNode(String value) {
    this.value = value;
    this.leftNode = null;
    this.rightNode = null;
  }

  public BitTreeNode(String value, BitTreeNode leftNode, BitTreeNode rightNode) {
    this.value = value;
    this.leftNode = leftNode;
    this.rightNode = rightNode;
  }

  public String getValue() {
    return this.value;
  }

  public BitTreeNode getLeftNode() {
    return this.leftNode;
  }

  public BitTreeNode getRightNode() {
    return this.rightNode;
  }

  public String setValue(String value) {
    return this.value = value;
  }

  public BitTreeNode getLeftNode(BitTreeNode leftNode) {
    return this.leftNode;
  }

  public BitTreeNode getRightNode(BitTreeNode rightNode) {
    return this.rightNode = rightNode;
  }
}
